import java.util.*;
import java.io.*;

public class FileCompare {
    /**
     * While the current line of both files is not null
     * Set current line of file 1 to input and current line of file 2 to input 2
     * If both lines are not null
     * then compare their lengths, if one they're not equal add one to lines counter
     * then iterate through each character in input and input2, counting the total number of characters for each while also comparing the characters to each other from each file.
     * If they're not the same character then add the line number and character number to unmatched_chars and add to total_unmatched.
     * Add to the line number counter.
     * Now if either line is null but the other isn't, continue to add up the characters in that file and add the line number to unmatched_chars.
     * Check if both lines are null, if they are break the loop.
     * @param f1
     * @param f2
     */
    public static void charByChar(File f1, File f2) {
        ArrayList<String> unmatched_chars = new ArrayList<String>();
        int f1_chars = 0;
        int f2_chars = 0;
        int total_unmatched = 0;
        int lines = 0;

        BufferedReader file1;
        BufferedReader file2;

        try {
            file1 = new BufferedReader(new FileReader(f1));
            file2 = new BufferedReader(new FileReader(f2));

            String input;
            String input2;
            int lnum = 1;

            while (true) {
                input = file1.readLine();
                input2 = file2.readLine();

                if (input != null && input2 != null) {
                    if (input.length() != input2.length()) {
                        lines++;
                    }

                    for (int i = 0; i < input.length(); i++) {
                        f1_chars++;
                        if (input.charAt(i) != input2.charAt(i)) {
                            unmatched_chars.add(lnum + ":" + (i + 1));
                            total_unmatched++;
                        }
                    }

                    for (int i = 0; i < input2.length(); i++) {
                        f2_chars++;
                    }
                    lnum++;
                } else {
                    if (input == null && input2 != null) {
                        for (int i = 0; i < input2.length(); i++) {
                            f2_chars++;
                        }
                        lines++;
                        unmatched_chars.add(String.valueOf(lnum));
                    }
                    if (input != null && input2 == null) {
                        for (int i = 0; i < input.length(); i++) {
                            f1_chars++;
                        }
                        lines++;
                        unmatched_chars.add(String.valueOf(lnum));
                    }
                }

                if (input == null && input2 == null) {
                    break;
                }
            }
        } catch (FileNotFoundException input) {
            System.out.println(input.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        System.out.println("Character by character:\n" +
                "Unmatched characters: " + unmatched_chars + "\n" +
                "There are " + f1_chars + " characters in " + f1 + "\n" +
                "There are " + f2_chars + " characters in " + f2 + "\n" +
                "There were " + total_unmatched + " unmatched characters in the files\n" +
                "There were " + lines + " lines of different length.");
    }

    /**
     * Main function that sets f1 and f2 to the inputted files which is read from the command line and calls charByChar function
     * @param String[]
     * @param args
     */
    public static void main(String[] args) {
        File f1 = new File(args[0]);
        File f2 = new File(args[1]);

        charByChar(f1, f2);
    }
}
