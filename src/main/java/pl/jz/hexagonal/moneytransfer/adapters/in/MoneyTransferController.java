package pl.jz.hexagonal.moneytransfer.adapters.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.jz.hexagonal.moneytransfer.domain.port.in.MoneyTransfer;
import pl.jz.hexagonal.moneytransfer.domain.port.in.MoneyTransferCommand;
import pl.jz.hexagonal.moneytransfer.model.MoneyTransferResult;

@RestController
public class MoneyTransferController {

    private final MoneyTransfer moneyTransfer;

    public MoneyTransferController(MoneyTransfer moneyTransfer) {
        this.moneyTransfer = moneyTransfer;
    }

    //in true cqrs it should return void
    @PostMapping("/transfer")
    ResponseEntity<MoneyTransferResult> transferMoney(@RequestBody MoneyTransferCommand moneyTransferCommand) {
        MoneyTransferResult moneyTransferResult = moneyTransfer.transferMoney(moneyTransferCommand);
        return ResponseEntity.ok(moneyTransferResult);
    }
}
