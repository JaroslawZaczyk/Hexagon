package pl.jz.hexagonal.moneytransfer.model;

import java.math.BigDecimal;

public class MoneyTransferResult {

    private final Result result;
    private final String accountOneNumber;
    private final String accountTwoNumber;
    private final BigDecimal moneyAmount;
    private final String message;

    private MoneyTransferResult(Result result, String accountOneNumber,
                                String accountTwoNumber, BigDecimal moneyAmount, String message) {
        this.result = result;
        this.accountOneNumber = accountOneNumber;
        this.accountTwoNumber = accountTwoNumber;
        this.moneyAmount = moneyAmount;
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public String getAccountOneNumber() {
        return accountOneNumber;
    }

    public String getAccountTwoNumber() {
        return accountTwoNumber;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public String getMessage() {
        return message;
    }

    public static class MoneyTransferResultBuilder {
        private Result result;
        private String accountOneNumber;
        private String accountTwoNumber;
        private BigDecimal moneyAmount;
        private String message;

        public MoneyTransferResultBuilder result(Result result) {
            this.result = result;
            return this;
        }

        public MoneyTransferResultBuilder accountOne(String accountOneNumber) {
            this.accountOneNumber = accountOneNumber;
            return this;
        }

        public MoneyTransferResultBuilder accountTwo(String accountTwoNumber) {
            this.accountTwoNumber = accountTwoNumber;
            return this;
        }

        public MoneyTransferResultBuilder moneyAmount(BigDecimal moneyAmount) {
            this.moneyAmount = moneyAmount;
            return this;
        }

        public MoneyTransferResultBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MoneyTransferResult build() {
            return new MoneyTransferResult(result, accountOneNumber, accountTwoNumber, moneyAmount, message);
        }
    }
}
