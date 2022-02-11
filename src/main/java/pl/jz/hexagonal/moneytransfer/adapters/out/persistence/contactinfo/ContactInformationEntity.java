package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_info")
public class ContactInformationEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String accountNo;
    private String email;
    private String phoneNo;

    ContactInformationEntity(String accountNo, String email, String phoneNo) {
        this.accountNo = accountNo;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    ContactInformationEntity() {
    }

    String getAccountNo() {
        return accountNo;
    }

    String getEmail() {
        return email;
    }

    String getPhoneNo() {
        return phoneNo;
    }
}
