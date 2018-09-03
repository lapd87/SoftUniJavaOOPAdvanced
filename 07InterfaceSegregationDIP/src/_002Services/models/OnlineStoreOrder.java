package _002Services.models;

import _002Services.contracts.NotificationService;
import _002Services.contracts.ProcessingDevice;

public class OnlineStoreOrder implements ProcessingDevice {

    private NotificationService[] notifications;

    public OnlineStoreOrder(NotificationService... notifications) {
        this.notifications = notifications;
    }

    @Override
    public void process() {
        for (NotificationService notification : notifications) {
            if (notification.isActive()) {
                notification.sendNotification();
            }
        }
    }
}
