package pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account;

import pl.jz.hexagonal.moneytransfer.domain.port.out.AccountProvider;
import pl.jz.hexagonal.moneytransfer.model.Account;

public class AccountPersistenceAdapter implements AccountProvider {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountPersistenceAdapter(AccountRepository accountRepository,
                                     AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getAccount(String accountNo) {
        AccountEntity account = accountRepository.getByAccountNo(accountNo);
        return accountMapper.mapToDTO(account);
    }

    @Override
    public boolean saveAccount(Account account) {
        accountRepository.updateMoneyAmount(account.getAccountNo(), account.getMoney());
        return true;
    }
}
