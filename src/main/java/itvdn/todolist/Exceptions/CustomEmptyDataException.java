package itvdn.todolist.Exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomEmptyDataException extends DataAccessException {
    public CustomEmptyDataException(String msg) {
        super(msg);
    }

    public CustomEmptyDataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
