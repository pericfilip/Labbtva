package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int rakna = 0;

    public static void main(String[] args) {
        File startingFolder = new File("testData");
        Scanner anv = new Scanner(System.in);

        String letastring;
        System.out.println("Hallå där! ");
        System.out.print("Vänligen ange sökord: ");
        letastring = anv.next();
        System.out.println("----------");
        try {
            printInfo(startingFolder, letastring);
        } catch (Exception e) {
            System.out.println("Oops");
            e.printStackTrace();
        }

    }
    public static void printInfo(File file, String string) {
        try{
        if (file.isDirectory()) {
            File [] folderCon = file.listFiles();
            for(File convag : folderCon){
                printInfo(convag, string);
            }
        }    else if (file.isFile()){
            Scanner fileScan = new Scanner(file);

            while(fileScan.hasNextLine()) {
                fileScan.nextLine();
                if(string.equals(fileScan.findInLine(string))) {
                    System.out.println(file.getCanonicalPath());
                    rakna++;
                    return;
                }
            }
        }
            if(!file.canRead()) {
                System.err.println("Fel: Kan inte läsa " + file.getCanonicalPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}