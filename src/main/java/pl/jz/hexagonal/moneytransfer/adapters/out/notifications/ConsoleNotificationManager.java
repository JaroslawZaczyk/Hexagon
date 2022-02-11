package pl.jz.hexagonal.moneytransfer.adapters.out.notifications;

import pl.jz.hexagonal.moneytransfer.domain.port.out.UserNotificationManager;
import pl.jz.hexagonal.moneytransfer.model.Message;

public class ConsoleNotificationManager implements UserNotificationManager {

    @Override
    public void notifyUser(Message message) {
        System.out.println(message);
    }
}
