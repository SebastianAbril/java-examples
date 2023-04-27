package springbootmigrations.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootmigrations.controller.dto.TransferRequest;
import springbootmigrations.service.AccountService;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public ResponseEntity makeTransfer(@RequestBody TransferRequest request) {
        accountService.makeTransfer(
                request.getAccountOriginId(),
                request.getAccountDestinationId(),
                request.getAmount()
        );
        return ResponseEntity.ok().build();
    }

}
