package springbootmigrations.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootmigrations.entity.Account;
import springbootmigrations.repository.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void makeTransfer(Long accountOriginId, Long accountDestinationId, Double amount) {
        Account accountOrigin = accountRepository.findById(accountOriginId)
                .orElseThrow(() -> new RuntimeException("Account with id " + accountOriginId+ " not found"));


        Account accountDestination = accountRepository.findById(accountDestinationId)
                .orElseThrow(() -> new RuntimeException("Account with id " + accountDestinationId+ " not found"));


        if (accountOrigin.getBalance() < amount) {
            throw new RuntimeException("Account with id " + accountOriginId+ " no tiene plata");
        }


        accountOrigin.setBalance(accountOrigin.getBalance() - amount);
        accountDestination.setBalance(accountDestination.getBalance() + amount);

        accountRepository.save(accountOrigin);

        Account pepe = null;
        pepe.toString();


        accountRepository.save(accountDestination);
    }

}
