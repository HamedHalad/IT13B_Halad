package Midterm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;




public class encryption {

    public static void main(String[] args) throws IOException {
          String[] phrases = {
            "I love you!",
            "Gwapa ko!",
            "Buotan si Maam"
        };
        File myFile;
        myFile = new File(
        "C:\\Users\\Doofenshmirtz\\Documents\\encryption.txt");

            if (myFile.createNewFile()) {
            System.out.println("File created: " + myFile.getName());
        } else {
            System.out.println("File already exists.");
        }
         try (FileWriter myWriter = new FileWriter(myFile)) {
            System.out.println("\nEncryption Results (Caesar Shift +3):");
          
            
            for (int i = 0; i < phrases.length; i++) {
                String original = phrases[i];
                String encrypted = encrypt(original, 6);
                
                // Display in console
                System.out.println((i+1) + ". Original : " + original);
                System.out.println("   Encrypted: " + encrypted);
                System.out.println();
                
                // Write to file
                myWriter.write((i+1) + ". Original : " + original + "\n");
                myWriter.write("   Encrypted: " + encrypted + "\n\n");
            }
            
            System.out.println("The messages successfully encrypted and saved to file!");
        } catch (IOException e) {
            System.out.println("There's an Error when writing to file: " + e.getMessage());
        }
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char)((c - base + shift) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }
}