package _02Blobs.notifiers;

import _02Blobs.core.commands.ReportEventsCommand;
import _02Blobs.io.interfaces.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 16:13 ч.
 */
public class BlobNotifier {

    private Writer writer;

    public BlobNotifier() {
        this.writer = new ReportEventsCommand().getWriter();
    }

    public void showMessage(String message) {
        this.writer.writeLine(message);
    }
}