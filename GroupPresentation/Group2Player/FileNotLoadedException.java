package Group2Player;

public class FileNotLoadedException extends RuntimeException {
    public FileNotLoadedException() {
        super("Video file is not loaded.");
    }
}
