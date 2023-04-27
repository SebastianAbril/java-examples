package springbootmigrations.exceptions;

public class CustomerNotFoundException extends NotFoundException{

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
