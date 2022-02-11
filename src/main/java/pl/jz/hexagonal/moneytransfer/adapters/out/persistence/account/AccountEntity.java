package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String accountNo;
    private String owner;
    private BigDecimal money;

    AccountEntity() {
    }

    AccountEntity(String accountNo, String owner, BigDecimal money) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.money = money;
    }

    String getAccountNo() {
        return accountNo;
    }

    String getOwner() {
        return owner;
    }

    BigDecimal getMoney() {
        return money;
    }
}
