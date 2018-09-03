package _002StreamProgressInfo;

public class File extends Streamable {

    private String name;

    public File(int length, int bytesSent) {
        super(length, bytesSent);
    }
}
