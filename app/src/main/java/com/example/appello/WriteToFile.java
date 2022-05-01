package com.example.appello;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class WriteToFile {
    String nameFile;
    String directory;
    FileWriter out;

    public WriteToFile( String dir, String namef){
        this.nameFile = namef;
        this.directory = dir;
        try{
            out = new FileWriter(this.directory+this.nameFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  boolean WriteRegistration(String[] regArray) throws IOException {
        try{

            out.write(regArray.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            out.close();
        }
        return false;

    }
}
