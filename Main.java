package ru.gb.stream200302_lesson_6;

import java.io.*;

public class Main {

    public static void newFile(String fileName, byte[] text) {
        OutputStream out;
        try {
            out = new FileOutputStream(fileName);
            out.write(text);
            out.close ();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sumFiles(String fileNameBig, String fileNameLittle, String fileSum) {
        InputStream in;
        OutputStream out;
        try {
            out = new FileOutputStream(fileSum, true);
            FileInputStream fis= new FileInputStream(fileNameBig);
            int b;
            while ((b=fis.read())!=-1) {
                out.write (b);
                System.out.print((char) b);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       try {
          out = new FileOutputStream(fileSum, true);
          FileInputStream fis= new FileInputStream(fileNameLittle);
          int b;
          while ((b=fis.read())!=-1)
              out.write (b);
            System.out.print((char) b);
           fis.close();
       } catch (IOException e) {
            e.printStackTrace();
       }
    }

    public static void main(String[] args) {

        newFile("fileBig.txt","ABCDEFGHIGKLMNOPQRSTUVWXYZ\n".getBytes());
        newFile("fileLittle.txt","abcdefghijklmnopqrstuvwxyz\n".getBytes());
        sumFiles("fileBig.txt","fileLittle.txt","fileSum.txt");
    }
}
