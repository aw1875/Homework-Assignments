import java.io.*;
import java.util.*;

public class FileCompare {
    File file1 = new File("");
    File file2 = new File("");
    public static void charByChar (File file1, File file2) throws FileNotFoundException {
        try {
            Scanner f1 = new Scanner(file1);
            Scanner f2 = new Scanner(file2);
        }
        catch (FileNotFoundException f) {
            System.out.print("One or more files not found.");
        }
    }
}
