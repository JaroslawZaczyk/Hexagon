package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo;

import pl.jz.hexagonal.moneytransfer.model.ContactInformation;

public class ContactInformationMapper {
    ContactInformation mapToDTO(ContactInformationEntity contactInformation) {
        return new ContactInformation(contactInformation.getEmail(), contactInformation.getPhoneNo());
    }
}
