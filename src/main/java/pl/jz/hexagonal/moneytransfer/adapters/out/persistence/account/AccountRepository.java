package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity getByAccountNo(String accountNo);

    @Modifying(clearAutomatically = true)
    @Query(value = "update account set money=:moneyAmount " +
                   "where account_no=:accountNo", nativeQuery = true)
    @Transactional
    void updateMoneyAmount(String accountNo, BigDecimal moneyAmount);
}
