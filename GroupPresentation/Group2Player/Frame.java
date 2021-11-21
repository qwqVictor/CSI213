package Group2Player;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Frame {
    String frameStr;

    public Frame(int width, int height, byte[] data) throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(data);
        StringBuilder builder = new StringBuilder((width + 1) * height);
        for (int i = 0; i < height; i++) {
            builder.append(new String(stream.readNBytes(width), StandardCharsets.US_ASCII));
            builder.append("\n");
        }
        this.frameStr = builder.toString();
    }

    public String toString() {
        return this.frameStr;
    }
}
