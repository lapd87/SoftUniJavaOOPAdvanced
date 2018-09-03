package _002Services.models.notificationServices;

import _002Services.io.interfaces.Writer;

public class EmailNotificationService extends BaseNotificationService {


    public EmailNotificationService(boolean isActive, Writer writer) {
        super(isActive, writer);
    }

    @Override
    public void sendNotification() {
        super.write("email notification");
    }
}
