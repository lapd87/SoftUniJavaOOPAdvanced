package _002Services;

import _002Services.contracts.ProcessingDevice;
import _002Services.io.impl.ConsoleWriter;
import _002Services.models.notificationServices.EmailNotificationService;
import _002Services.models.OnlineStoreOrder;
import _002Services.models.notificationServices.SmsNotificationService;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 11:45 ч.
 */
public class Main {
    public static void main(String[] args) {

        ProcessingDevice onlineStoreOrder = new OnlineStoreOrder(
                new SmsNotificationService(true,
                        new ConsoleWriter()),
                new EmailNotificationService(true,
                        new ConsoleWriter()));

        onlineStoreOrder.process();

    }
}