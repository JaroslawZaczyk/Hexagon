package pl.jz.hexagonal.moneytransfer.domain.port.out;

import pl.jz.hexagonal.moneytransfer.model.Account;

public interface AccountProvider {
    Account getAccount(String accountNo);
    boolean saveAccount(Account account);
}
