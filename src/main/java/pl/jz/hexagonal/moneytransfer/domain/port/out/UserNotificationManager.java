package pl.jz.hexagonal.moneytransfer.domain.port.out;

import pl.jz.hexagonal.moneytransfer.model.Message;

public interface UserNotificationManager {

    void notifyUser(Message message);
}
