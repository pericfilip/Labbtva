package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File startingFolder = new File("./");
        Scanner anv = new Scanner(System.in);
        String letastring;

        System.out.println("Hallå där! ");
        System.out.print("Vänligen ange sökord: ");
        letastring = anv.next();
        System.out.println("----------");

        try {
            printInfo(startingFolder, letastring);
        } catch (Exception e) {
            System.out.println("Något har blivit fel");
            e.printStackTrace();
        }
    }

    public static void printInfo(File file, String string) {
        try {
            if (file.isDirectory()) {
                File[] folderCon = file.listFiles();
                for(File convag : folderCon) {
                    printInfo(convag, string);
                }
            } else if (file.isFile()) {
                Scanner fileScan = new Scanner(file);

                while(fileScan.hasNextLine()) {
                    String fileSC = fileScan.nextLine();
                    String filescanLow = fileSC.toLowerCase();

                    if (filescanLow.contains(string.toLowerCase())) {
                        System.out.println("Funnen i följande: " + file.getCanonicalPath());
                    }
                    return;
                }
                fileScan.close();
            }
            if(!file.canRead()) {
                System.err.println("ERROR: Kan inte läsa " + file.getCanonicalPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}