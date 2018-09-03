package _01Logger.models.appenders;

import _01Logger.interfaces.Layout;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:52 ч.
 */
public class ConsoleAppender extends BaseAppender {

    private ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void printAll() {
        System.out.println(super.getLogsData());
    }
}