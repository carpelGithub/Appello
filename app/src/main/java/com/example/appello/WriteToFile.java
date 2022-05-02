package com.example.appello;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class WriteToFile {
    String nameFile;
    String directory;
    FileWriter out;

    public WriteToFile( String dir, String namef){
        this.nameFile = namef;
        this.directory = dir;
        try{
            out = new FileWriter (this.directory+"/"+this.nameFile, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  boolean WriteRegistration(String regArray) throws IOException {
        try{

            out.append(regArray);
            out.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            out.close();
        }
        return true;

    }
}
