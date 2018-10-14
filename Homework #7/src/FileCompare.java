import java.util.*;
import java.io.*;

public class FileCompare {
    public static String charByChar(File f1, File f2) {
        ArrayList<Integer> unmatched_chars = new ArrayList<Integer>();
        int f1_chars = 0;
        int f2_chars = 0;
        int total_unmatched = 0;
        int lines = 0;

        BufferedReader file1;
        BufferedReader file2;

        try {
            file1 = new BufferedReader(new FileReader("src/" + f1));
            file2 = new BufferedReader(new FileReader("src/" + f2));

            String input;
            String [] test = new String[(int) f1.length()];
            String [] test2;
            while ((input = file1.readLine()) != null) {
                test = input.split("");
                for (int i = 0; i < input.length(); i++) {
                    f1_chars++;
                }
            }

            input = null;

            while ((input = file2.readLine()) != null) {
                for (int i = 0; i < input.length(); i++) {
                    f2_chars++;
                }
            }

        } catch (FileNotFoundException input) {
            System.out.println(input.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return "Character by character:\n" +
                "Unmatched characters: \n" +
                "There are " + f1_chars + " characters in " + f1 + "\n" +
                "There are " + f2_chars + " characters in " + f2 + "\n" +
                "There were " + total_unmatched + " unmatched characters in the files\n" +
                "There were " + lines + " lines of different length.";
    }

    public static void main (String [] args) {
        File f1 = new File("t1.txt");
        File f2 = new File("t2.txt");

        System.out.println(charByChar(f1,f2));
    }
}
