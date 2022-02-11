package pl.jz.hexagonal.moneytransfer.adapters.out.notifications;

import pl.jz.hexagonal.moneytransfer.domain.port.out.UserNotificationManager;
import pl.jz.hexagonal.moneytransfer.model.Message;

public class MailNotificationManager implements UserNotificationManager {

    @Override
    public void notifyUser(Message message) {
        System.out.println("sending email message to: " + message.getUserIdentifier().getEmail());
    }
}
