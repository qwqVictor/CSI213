public interface LinkedStringInterface {
    char charAt(int index);
    LinkedString concat(LinkedString other);
    boolean isEmpty();
    int length();
    LinkedString substring(int begin, int end);
}
