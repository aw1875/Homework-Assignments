import java.util.Collection;

public class PuzzleConfig implements Configuration {

    public PuzzleConfig (String filename) {

    }

    public PuzzleConfig (PuzzleConfig config) {

    }

    public String toString() {
        return super.toString();
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

    public static void main (String [] args) {

    }
}
