package com.pajehyk.files;

/**
 * Exception that thrown in case of wrong number of passed arguments.
 */
public class InvalidArgumentsException extends Exception {
    public InvalidArgumentsException(String message) {
        super(message);
    }
}
