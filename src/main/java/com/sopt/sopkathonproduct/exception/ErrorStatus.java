package com.sopt.sopkathonproduct.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /*
    UNAUTHORIZED
    */
    INVALID_MEMBER(HttpStatus.UNAUTHORIZED, "유효하지 않은 멤버입니다."),

    /*
    NOT_FOUND
     */
    NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 게시물이 존재하지 않습니다."),

    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),
    /*
    CONFLICT
     */

    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생하였습니다."),
    BAD_GATEWAY_EXCEPTION(HttpStatus.BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),
    SERVICE_UNAVAILABLE_EXCEPTION(HttpStatus.SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}