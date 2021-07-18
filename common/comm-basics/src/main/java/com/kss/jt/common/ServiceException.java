package com.kss.jt.common;
/*异常对象*/
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 4956028347983361179L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
