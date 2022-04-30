package com.example.appello;

import android.widget.EditText;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    String nameFile;
    String directory;
    Scanner in;

    public ReadFromFile( String dir, String namef){
        this.nameFile = namef;
        this.directory = dir;
    try{
        in = new Scanner(new File(this.directory, this.nameFile));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }

    public  boolean isValidLogin(EditText username, EditText pass){
        String[] sArray;

        while (in.hasNextLine()) {

            sArray = in.nextLine().split(",");

            if (username.getText().toString().equals(sArray[0]) && pass.getText().toString().equals(sArray[1])) {
                in.close();
                return true;

            }
        }
        // credenziali errate
        in.close();
        return false;

    }
}
