package Week2_CopyingAFile;

/*
    CopyfFile.java
    Reads input from user, search the file, and copies it
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class CopyFile {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter the name of the file (must be a .txt file)");
            try {
                String input =  new Scanner(System.in).nextLine();
                File fileObj = new File("src/main/java/Week2_CopyingAFile/"+ input + ".txt");
                Scanner scan = new Scanner(fileObj);
                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
                break;
            // Continue the loop if the file doesn't exist
            } catch (FileNotFoundException e) {
                System.out.println(e);
                continue;
            }
        }
    }
}