package _01Logger.models.layouts;

import _01Logger.interfaces.Layout;
import _01Logger.interfaces.Log;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:50 ч.
 */
public class XmlLayout implements Layout {

    private XmlLayout() {
    }

    @Override
    public String formatLog(Log log) {
        return String.format("<log>%n" +
                        "\t<date>%s</date>%n" +
                        "\t<level>%s</level>%n" +
                        "\t<message>%s</message>%n" +
                        "</log>",
                log.getDateTime(),
                log.getReportLevel(),
                log.getMessage());
    }
}