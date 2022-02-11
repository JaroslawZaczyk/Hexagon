package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account;

import pl.jz.hexagonal.moneytransfer.model.Account;

public class AccountMapper {
    Account mapToDTO(AccountEntity account) {
        return new Account(account.getAccountNo(), account.getOwner(), account.getMoney());
    }
}
