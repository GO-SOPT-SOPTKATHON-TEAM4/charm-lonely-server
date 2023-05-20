package com.sopt.sopkathonproduct.exception;

public class NotFoundException extends SoptException {

    public NotFoundException(ErrorStatus error) {
        super(error, error.getMessage());
    }
}

