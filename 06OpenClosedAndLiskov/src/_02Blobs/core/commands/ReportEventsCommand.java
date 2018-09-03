package _02Blobs.core.commands;

import _02Blobs.annotations.Inject;
import _02Blobs.interfaces.Executable;
import _02Blobs.io.interfaces.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:59 ч.
 */
public class ReportEventsCommand implements Executable {

    @Inject
    private static Writer writer;

    private static boolean shouldReport = false;

    public ReportEventsCommand() {
    }

    public boolean shouldReport() {
        return shouldReport;
    }

    public Writer getWriter() {
        return writer;
    }

    @Override
    public void execute() {
        shouldReport = true;
    }
}