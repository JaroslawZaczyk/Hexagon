package pl.jz.hexagonal.moneytransfer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jz.hexagonal.moneytransfer.adapters.out.notifications.ConsoleNotificationManager;
import pl.jz.hexagonal.moneytransfer.adapters.out.notifications.MailNotificationManager;
import pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account.AccountMapper;
import pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account.AccountPersistenceAdapter;
import pl.jz.hexagonal.moneytransfer.adapters.out.persistence.account.AccountRepository;
import pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo.ContactInformationAdapter;
import pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo.ContactInformationMapper;
import pl.jz.hexagonal.moneytransfer.adapters.out.persistence.contactinfo.ContactInformationRepository;
import pl.jz.hexagonal.moneytransfer.domain.port.in.MoneyTransfer;
import pl.jz.hexagonal.moneytransfer.domain.service.MoneyTransferService;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    AccountPersistenceAdapter accountPersistenceAdapter(AccountRepository repository) {
        return new AccountPersistenceAdapter(repository, new AccountMapper());
    }

    @Bean
    ContactInformationAdapter contactInformationAdapter(ContactInformationRepository repository) {
        return new ContactInformationAdapter(repository, new ContactInformationMapper());
    }

    @Bean
    MoneyTransfer moneyTransfer(AccountPersistenceAdapter accountPersistenceAdapter,
                                ContactInformationAdapter contactInformationAdapter) {
        return new MoneyTransferService(accountPersistenceAdapter,
                contactInformationAdapter,
                List.of(new ConsoleNotificationManager(), new MailNotificationManager()));
    }

}
