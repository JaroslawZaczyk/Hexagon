package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo;

import pl.jz.hexagonal.moneytransfer.domain.port.out.UserContactProvider;
import pl.jz.hexagonal.moneytransfer.model.ContactInformation;

public class ContactInformationAdapter implements UserContactProvider {

    private final ContactInformationRepository contactInformationRepository;
    private final ContactInformationMapper contactInformationMapper;

    public ContactInformationAdapter(ContactInformationRepository contactInformationRepository,
                                     ContactInformationMapper contactInformationMapper) {
        this.contactInformationRepository = contactInformationRepository;
        this.contactInformationMapper = contactInformationMapper;
    }

    @Override
    public ContactInformation getContactInformationForAccountOwner(String accountNo) {
        ContactInformationEntity contactInformation =
                contactInformationRepository.getAllContactInformationByAccountNo(accountNo);
        return contactInformationMapper.mapToDTO(contactInformation);
    }
}
