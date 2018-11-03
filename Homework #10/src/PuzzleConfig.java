import java.io.*;
import java.util.*;

public class PuzzleConfig implements Configuration {

    /**
     * Take in a file and construct the initial puzzle from it.
     *
     * @param filename - file containing puzzle
     */
    public PuzzleConfig(String filename) {
        int board[][] = new int[9][9];
        int counter = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            String input;
            while ((input = bf.readLine()) != null) {
                String currLine[] = input.split(" ");
                for (int i = 0; i < currLine.length; i++) {
                    if (currLine[i].equals(".")) {
                        board[counter][i] = 0;
                    } else {
                        board[counter][i] = Integer.parseInt(currLine[i]);
                    }
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public PuzzleConfig(PuzzleConfig config) {

    }

    public String toString() {
        String result = "";
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result += board[i][j] + " ";
            }
            System.out.println(result);
            result = "";
        }
        return result;
    }


    @Override
    public Collection<Configuration> getSuccessors() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean isGoal() {
        return false;
    }

    public static void main(String[] args) {
        PuzzleConfig p1 = new PuzzleConfig("src/b1.txt");


    }
}
