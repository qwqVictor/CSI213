package Group2Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Player {
    static final String RunOS = System.getProperty("os.name");
    Video currentVideo;
    int currentFrame;

    private void clearScreen() {
        if (RunOS.contains("Windows")) {
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException e) {
                System.out.println("\n".repeat(this.currentVideo.height + 2));
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public Player() {
        this.currentVideo = null;
        this.currentFrame = 0;
    }

    public void load(String filename) throws IOException, InvalidFileException {
        load(new File(filename));
    }

    public void load(File file) throws IOException, InvalidFileException {
        FileInputStream inputStream = new FileInputStream(file);
        load(inputStream);
    }

    public void load(FileInputStream inputStream) throws IOException, InvalidFileException {
        BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
        this.currentVideo = new Video(bufferedStream);
        this.currentFrame = 0;
    }

    private String generateTime(int frame) {
        double timestamp = frame * this.currentVideo.getDuration();
        return generateTime(timestamp);
    }

    private String generateTime(double timestamp) {
        return String.format("%02d:%06.03f", (int) Math.floor(timestamp / 60), timestamp % 60);
    }

    private String generateHeader(double timestamp) {
        StringBuilder builder = new StringBuilder();
        String title = "<" + this.currentVideo.getTitle() + ">";
        String time = "Time: " + this.generateTime(timestamp) + "/" + this.generateTime(this.currentVideo.frameCount);
        if (title.length() + time.length() < this.currentVideo.width) {
            builder.append(title);
            builder.append(" ".repeat(this.currentVideo.width - (title.length() + time.length())));
            builder.append(time);
        } else if (title.length() > this.currentVideo.width) {
            builder.append(title);
            builder.append("\n");
            builder.append(time);
        } else {
        }
        builder.append("\n");
        return builder.toString();
    }

    public void play() throws FileNotLoadedException {
        if (this.currentVideo == null) {
            throw new FileNotLoadedException();
        }
        double roll_time = 1.0 / this.currentVideo.fps;
        long roll_time_milli = (long) Math.floor(roll_time * 1000);
        int roll_time_nano = (int) Math.floor(roll_time * 1000 * 1000) % 1000;
        for (this.currentFrame = 0; this.currentFrame < this.currentVideo.getFrameCount(); this.currentFrame++) {
            String frameData = this.currentVideo.nextFrame();
            this.clearScreen();
            if (frameData == null) {
                break;
            }
            System.out.println(generateHeader(this.currentFrame * roll_time));
            System.out.println(frameData);
            System.out.flush();
            try {
                Thread.sleep(roll_time_milli, roll_time_nano);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
