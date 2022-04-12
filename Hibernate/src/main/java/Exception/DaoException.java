package Exception;

import lombok.extern.java.Log;

@Log
public class DaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DaoException(String message) {
        super(message);

        log.severe(getMessage());
    }
}
