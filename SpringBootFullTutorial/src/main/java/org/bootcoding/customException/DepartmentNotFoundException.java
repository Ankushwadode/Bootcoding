package org.bootcoding.customException;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
