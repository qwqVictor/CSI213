package Group2Player;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class Video {
    static final byte[] MagicHeader = { 'G', 'R', 'P', '2' };
    static final int PREFETCH_TIME_SECS = 5;
    String title;
    int fps;
    int width;
    int height;
    int frameCount;
    BetterQueue<Frame> frames;
    BufferedInputStream bufferedStream;

    public Video(BufferedInputStream bufferedStream) throws InvalidFileException, IOException {
        this.bufferedStream = bufferedStream;
        byte[] magic = bufferedStream.readNBytes(4); // 4-byte magic header
        for (int i = 0; i < 4; i++) {
            if (magic[i] != MagicHeader[i])
                throw new InvalidFileException();
        }
        this.title = new String(bufferedStream.readNBytes(60), StandardCharsets.UTF_8).trim(); // 60-byte title in UTF-8 encoding
        this.fps = new BigInteger(1, bufferedStream.readNBytes(1)).intValue(); // 1-byte fps
        this.width = new BigInteger(1, bufferedStream.readNBytes(1)).intValue(); // 1-byte width
        this.height = new BigInteger(1, bufferedStream.readNBytes(1)).intValue(); // 1-byte height
        this.frameCount = new BigInteger(1, bufferedStream.readNBytes(5)).intValue(); // 5-bytes frameCount
        this.frames = new BetterQueue<Frame>();
        this.prefetch(PREFETCH_TIME_SECS);
    }

    public double getDuration() {
        final double cachedValue = 1.0 / this.fps;
        return cachedValue;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    private void prefetch(int seconds) throws IOException {
        for (int i = 0; i < seconds * this.fps && i < frameCount && bufferedStream.available() >= width * height; i++) {     // prefetch for 5 secs
            this.frames.push(new Frame(this.width, this.height, this.bufferedStream.readNBytes(width * height)));
        }
    }

    public String nextFrame() {
        if (this.frames.size() < PREFETCH_TIME_SECS * fps / 2) {
            try {
                this.prefetch(PREFETCH_TIME_SECS);
            } catch (IOException e) {
                if (this.frames.isEmpty()) return null;
            }
        }
        try {
            return this.frames.pop().toString();
        } catch (QueueOutOfBoundException e) {
            return null;
        }
    }
}
