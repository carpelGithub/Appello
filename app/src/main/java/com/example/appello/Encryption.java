package com.example.appello;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class Encryption {
    // The salt (probably) can be stored along with the encrypted data
    static byte[] salt = "12345678".getBytes();
    // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
    static int iterationCount = 40000;
    // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
    static int keyLength = 128;

    static char[] password = "start-key".toCharArray();
    static SecretKeySpec key = null;

    private static void createSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
        key = new SecretKeySpec(keyTmp.getEncoded(), "AES");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        if (key == null) createSecretKey();

        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters parameters = pbeCipher.getParameters();
        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
        byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
        byte[] iv = ivParameterSpec.getIV();
        return base64Encode(iv) + ":" + base64Encode(cryptoText);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String decrypt(String string) throws GeneralSecurityException, IOException {
        if (key == null) createSecretKey();

        String iv = string.split(":")[0];
        String property = string.split(":")[1];
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private static byte[] base64Decode(String property) throws IOException {
        return Base64.getDecoder().decode(property);
    }
}
