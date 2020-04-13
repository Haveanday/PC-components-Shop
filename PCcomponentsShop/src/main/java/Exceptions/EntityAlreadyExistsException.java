package Exceptions;

import java.util.logging.Logger;

public class EntityAlreadyExistsException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(String.valueOf(EntityNotFoundException.class.getName()));

    public EntityAlreadyExistsException() {
        logger.severe("This entity already exists.");
    }
}
