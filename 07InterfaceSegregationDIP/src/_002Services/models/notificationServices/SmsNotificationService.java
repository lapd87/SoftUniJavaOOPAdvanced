package _002Services.models.notificationServices;

import _002Services.io.interfaces.Writer;

public class SmsNotificationService extends BaseNotificationService {

    public SmsNotificationService(boolean isActive, Writer writer) {
        super(isActive, writer);
    }

    @Override
    public void sendNotification() {
        super.write("sms notification");
    }
}
