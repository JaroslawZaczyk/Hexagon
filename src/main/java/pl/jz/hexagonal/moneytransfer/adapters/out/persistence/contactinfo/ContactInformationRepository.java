package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformationEntity, Long> {
    @Query(value = "select id, account_no, email, phone_no from contact_info where account_no = :accountNo", nativeQuery = true)
    ContactInformationEntity getAllContactInformationByAccountNo(String accountNo);
}
