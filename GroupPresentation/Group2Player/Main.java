package Group2Player;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No file provided");
            System.exit(1);
        }
        Player player = new Player();
        try {
            player.load(args[0]);
            player.play();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}