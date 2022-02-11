package pl.jz.hexagonal.moneytransfer.domain.service;

import pl.jz.hexagonal.moneytransfer.domain.port.in.MoneyTransfer;
import pl.jz.hexagonal.moneytransfer.domain.port.in.MoneyTransferCommand;
import pl.jz.hexagonal.moneytransfer.domain.port.out.AccountProvider;
import pl.jz.hexagonal.moneytransfer.domain.port.out.UserContactProvider;
import pl.jz.hexagonal.moneytransfer.domain.port.out.UserNotificationManager;
import pl.jz.hexagonal.moneytransfer.model.Account;
import pl.jz.hexagonal.moneytransfer.model.Message;
import pl.jz.hexagonal.moneytransfer.model.MoneyTransferResult;
import pl.jz.hexagonal.moneytransfer.model.Result;

import java.math.BigDecimal;
import java.util.List;

public class MoneyTransferService implements MoneyTransfer {

    private static final String OK_MESSAGE = "Money transferred successfully";
    private final AccountProvider accountProvider;
    private final UserContactProvider userContactProvider;
    private final List<UserNotificationManager> userNotificationManager;

    public MoneyTransferService(AccountProvider accountProvider,
                                UserContactProvider userContactProvider,
                                List<UserNotificationManager> userNotificationManager) {
        this.accountProvider = accountProvider;
        this.userContactProvider = userContactProvider;
        this.userNotificationManager = userNotificationManager;
    }

    @Override
    public MoneyTransferResult transferMoney(MoneyTransferCommand moneyTransferCommand) {
        String accountOneNo = moneyTransferCommand.getAccountOneNo();
        String accountTwoNo = moneyTransferCommand.getAccountTwoNo();

        Account firstAccount = accountProvider.getAccount(accountOneNo);
        Account secondAccount = accountProvider.getAccount(accountTwoNo);

        BigDecimal moneyAmount = moneyTransferCommand.getMoneyAmount();
        firstAccount.subMoney(moneyAmount);
        secondAccount.addMoney(moneyAmount);

        accountProvider.updateAccountAmount(firstAccount);
        accountProvider.updateAccountAmount(secondAccount);

        userNotificationManager.forEach(n -> notifyUsers(n, accountOneNo, accountTwoNo));

        return new MoneyTransferResult.MoneyTransferResultBuilder()
                .accountOne(accountOneNo)
                .accountTwo(accountTwoNo)
                .moneyAmount(moneyAmount)
                .result(Result.SUCCESS)
                .message(OK_MESSAGE)
                .build();
    }

    private void notifyUsers(UserNotificationManager notificationManager, String accountNoOne, String accountNoTwo) {
        notificationManager.notifyUser(new Message(OK_MESSAGE,
                userContactProvider.getContactInformationForAccountOwner(accountNoOne)));
        notificationManager.notifyUser(new Message(OK_MESSAGE,
                userContactProvider.getContactInformationForAccountOwner(accountNoTwo)));
    }
}
