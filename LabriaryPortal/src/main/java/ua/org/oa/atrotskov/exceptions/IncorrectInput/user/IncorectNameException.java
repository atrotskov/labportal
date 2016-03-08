package ua.org.oa.atrotskov.exceptions.IncorrectInput.user;

import ua.org.oa.atrotskov.exceptions.IncorrectInput.IncorrectInputException;

/**
 * Created by jdev on 29.12.2015.
 */
public class IncorectNameException extends IncorrectInputException {
    public IncorectNameException(String msg) {
        super(msg);
    }
    public IncorectNameException() {

    }
}
