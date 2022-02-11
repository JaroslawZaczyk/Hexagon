package pl.jz.hexagonal.moneytransfer.adapters.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.jz.hexagonal.moneytransfer.model.IllegalMoneyAmountException;
import pl.jz.hexagonal.moneytransfer.model.MoneyTransferResult;
import pl.jz.hexagonal.moneytransfer.model.Result;

@ControllerAdvice
public class MoneyTransferControllerAdvice {

    @ExceptionHandler(IllegalMoneyAmountException.class)
    ResponseEntity<MoneyTransferResult> handleIllegalMoneyAmountException() {
        return new ResponseEntity<>(new MoneyTransferResult.MoneyTransferResultBuilder()
                .result(Result.FAILURE)
                .message("Illegal operation")
                .build(), HttpStatus.BAD_REQUEST);
    }
}
