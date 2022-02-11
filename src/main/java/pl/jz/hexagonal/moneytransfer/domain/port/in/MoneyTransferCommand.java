package pl.jz.hexagonal.moneytransfer.domain.port.in;

import java.math.BigDecimal;

//request to transfer money
public class MoneyTransferCommand {

    private String accountOneNo;
    private String accountTwoNo;
    private BigDecimal moneyAmount;

    public MoneyTransferCommand(String accountOneNo, String accountTwoNo, BigDecimal moneyAmount) {
        this.accountOneNo = accountOneNo;
        this.accountTwoNo = accountTwoNo;
        this.moneyAmount = moneyAmount;
    }

    public String getAccountOneNo() {
        return accountOneNo;
    }

    public String getAccountTwoNo() {
        return accountTwoNo;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }
}
