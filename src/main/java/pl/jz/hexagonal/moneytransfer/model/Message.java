package pl.jz.hexagonal.moneytransfer.model;

public class Message {

    private final String message;
    private final ContactInformation userIdentifier; // mail/phone no/fb account id...

    public Message(String message, ContactInformation channelIdentifier) {
        this.message = message;
        this.userIdentifier = channelIdentifier;
    }

    public String getMessage() {
        return message;
    }

    public ContactInformation getUserIdentifier() {
        return userIdentifier;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", userIdentifier=" + userIdentifier +
                '}';
    }
}
