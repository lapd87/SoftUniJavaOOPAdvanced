package _002StreamProgressInfo;

public class Music extends Streamable {

    private String artist;
    private String album;

    public Music(int length, int bytesSent) {
        super(length, bytesSent);
    }
}
