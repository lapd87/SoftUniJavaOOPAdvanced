package _002Services.models.notificationServices;

import _002Services.contracts.NotificationService;
import _002Services.io.interfaces.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 11:42 ч.
 */
public abstract class BaseNotificationService implements NotificationService {

    private boolean isActive;
    private Writer writer;

    public BaseNotificationService(boolean isActive, Writer writer) {
        this.isActive = isActive;
        this.writer = writer;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    protected void write(String line) {
        writer.writeLine(line);
    }
}