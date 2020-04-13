package Exceptions;

import java.util.logging.Logger;

public class EntityNotFoundException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(String.valueOf(EntityNotFoundException.class.getName()));

    public EntityNotFoundException() {
        logger.severe("Entity not found.");
    }
}
