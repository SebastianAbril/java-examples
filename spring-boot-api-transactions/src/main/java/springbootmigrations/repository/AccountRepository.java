package springbootmigrations.repository;

import org.springframework.data.repository.CrudRepository;
import springbootmigrations.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
