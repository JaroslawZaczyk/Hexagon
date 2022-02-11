package pl.jz.hexagonal.moneytransfer.model;

import java.math.BigDecimal;

//DTO class
public class Account {

    private String accountNo;
    private String owner;
    private BigDecimal money;

    public Account() {
        //for jackson
    }

    public Account(String accountNo, String owner, BigDecimal money) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.money = money;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getOwner() {
        return owner;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void addMoney(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalMoneyAmountException("Cannot add to the account money amount less than 0");
        }

        this.money = this.money.add(money);
    }

    public void subMoney(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalMoneyAmountException("Cannot subtract from the account money amount less than 0");
        }

        this.money = this.money.subtract(money);
    }
}
