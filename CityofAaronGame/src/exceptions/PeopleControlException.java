
package exceptions;

/**
 *
 * @author Amber Mitchell
 */
public class PeopleControlException extends Exception {

    public PeopleControlException() {
    }

    public PeopleControlException(String message) {
        super(message);
    }

    public PeopleControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public PeopleControlException(Throwable cause) {
        super(cause);
    }

    public PeopleControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
  
    
}
