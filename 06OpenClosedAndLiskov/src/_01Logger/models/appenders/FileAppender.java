package _01Logger.models.appenders;

import _01Logger.interfaces.Layout;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:52 ч.
 */
public class FileAppender extends BaseAppender {

    private static final String DEFAULT_FILE_NAME = "FileAppender";
    private static final String DEFAULT_FILE_PATH = System.getProperty("user.dir")
            + "/src/resources/" + DEFAULT_FILE_NAME;

    private FileAppender(Layout layout) {
        super(layout);
    }

    private long getFileSize() {
        String data = super.getLogsData();

        long size = 0;
        for (char c : data.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                size += c;
            }
        }

        return size;
    }

    @Override
    public String getAppenderInfo() {
        return super.getAppenderInfo()
                + String.format(", File size: %d",
                getFileSize());
    }

    @Override
    public void printAll() {
//        try (
//                OutputStream outputStream = new FileOutputStream(DEFAULT_FILE_PATH);
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))
//        ) {
//            bufferedWriter.write(super.getLogsData());
//        } catch (IOException ignored) {
//            ;
//        }
    }
}