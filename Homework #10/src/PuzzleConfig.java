import java.io.*;
import java.util.*;

public class PuzzleConfig implements Configuration {
    private int rows = 9;
    private int cols = 9;
    private int[][] board = new int[rows][cols];
    private int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * Take in a file and construct the initial puzzle from it.
     *
     * @param filename - file containing puzzle.
     */
    public PuzzleConfig(String filename) {
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

    /**
     * Make a copy of of the passed in configuration.
     *
     * @param config - passed in configuration
     */
    public PuzzleConfig(PuzzleConfig config) {
        for (int i = 0; i < config.board.length; i++) {
            this.board[i] = config.board[i].clone();
        }
    }

    /**
     * Print out the PuzzleConfig.
     *
     * @return result.
     */
    public String toString() {
        String result = "";
        for (int[] row : board) {
            for (int col : row) {
                result += (col + " ");
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Get the collection of successors from the current one.
     *
     * @return All successors, valid and invalid.
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    for (int n : numbers) {
                        PuzzleConfig successor = new PuzzleConfig(this);
                        successor.board[i][j] = n;
                        successors.add(successor);
                    }
                    return successors;
                }
            }
        }
        return successors;
    }

    /**
     * Is the current configuration valid or not?
     *
     * @return true if valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j];
                if (num != 0) {
                    for (int k = j + 1; k < board.length; k++) {
                        if (num == board[i][k]) {
                            return false;
                        }
                    }

                    for (int l = i + 1; l < board.length; l++) {
                        if (num == board[l][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Is the current configuration a goal?
     *
     * @return true if goal; false otherwise.
     */
    @Override
    public boolean isGoal() {
        for (int[] row : board) {
            for (int col : row) {
                if (col == 0) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Main function which will obtain a puzzle file from the command line.
     * Construct the puzzle and attempt to solve it.
     * Will print the solution if found; print No Solution if not found.
     *
     * @param args - command line arguments.
     */
    public static void main(String[] args) {
        PuzzleConfig puzzle = new PuzzleConfig(args[0]);
        Backtracker b1 = new Backtracker(false);
        Optional<Configuration> solution = b1.solve(puzzle);
        if (!solution.isPresent()) {
            System.out.println("No Solution");
        } else {
            System.out.println("\nSolution Found: \n\n" + solution.get());
        }
    }
}
