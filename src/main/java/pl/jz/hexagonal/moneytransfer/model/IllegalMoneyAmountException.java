package pl.jz.hexagonal.moneytransfer.model;

public class IllegalMoneyAmountException extends RuntimeException {
    public IllegalMoneyAmountException(String s) {
        super(s);
    }
}
