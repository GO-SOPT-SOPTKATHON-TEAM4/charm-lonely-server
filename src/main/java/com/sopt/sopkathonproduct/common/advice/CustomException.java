package com.sopt.sopkathonproduct.common.advice;

import com.sopt.sopkathonproduct.exception.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorStatus errorStatus;
}
