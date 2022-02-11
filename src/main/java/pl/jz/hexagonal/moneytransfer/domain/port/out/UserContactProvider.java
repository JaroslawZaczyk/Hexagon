package pl.jz.hexagonal.moneytransfer.domain.port.out;

import pl.jz.hexagonal.moneytransfer.model.ContactInformation;

public interface UserContactProvider {
    ContactInformation getContactInformationForAccountOwner(String accountNo);
}
