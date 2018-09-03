package _002StreamProgressInfo;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 15:32 ч.
 */
public class Streamable {

    private int length;
    private int bytesSent;

    public Streamable(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return length;
    }

    public int getBytesSent() {
        return bytesSent;
    }

}