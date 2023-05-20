package com.sopt.sopkathonproduct.exception;

import lombok.Getter;

@Getter
public class SoptException extends RuntimeException {

    private final ErrorStatus error;

    public SoptException(ErrorStatus error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return this.error.getHttpStatusCode();
    }

    public ErrorStatus getError() {
        return this.error;
    }
}