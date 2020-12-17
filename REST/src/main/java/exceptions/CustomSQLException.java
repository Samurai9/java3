package exceptions;

public class CustomSQLException extends Exception {
    public CustomSQLException() {
    }

    public CustomSQLException(String message) {
        super(message);
    }

    public CustomSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomSQLException(Throwable cause) {
        super(cause);
    }

    public CustomSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
