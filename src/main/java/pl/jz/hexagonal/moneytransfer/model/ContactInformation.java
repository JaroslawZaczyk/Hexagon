package pl.jz.hexagonal.moneytransfer.model;

public class ContactInformation {

    private final String email;
    private final String phoneNo;

    public ContactInformation(String email, String phoneNo) {
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
