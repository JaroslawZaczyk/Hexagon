package pl.jz.hexagonal.moneytransfer.domain.port.in;

import pl.jz.hexagonal.moneytransfer.model.MoneyTransferResult;

//use case interface - inbound port
public interface MoneyTransfer {
    MoneyTransferResult transferMoney(MoneyTransferCommand moneyTransferCommand);
}
