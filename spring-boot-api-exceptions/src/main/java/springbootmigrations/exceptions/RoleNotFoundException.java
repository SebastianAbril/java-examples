package springbootmigrations.exceptions;

public class RoleNotFoundException extends NotFoundException{

    public RoleNotFoundException(String message) {
        super(message);
    }

}
