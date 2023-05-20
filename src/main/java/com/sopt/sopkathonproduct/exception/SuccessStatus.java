package com.sopt.sopkathonproduct.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    HEALTH(HttpStatus.OK, "서버가 정상적으로 작동하고 있습니다."),

    // S3
    UPLOAD_POST_SUCCESS(HttpStatus.OK, "게시글이 성공적으로 업로드 되었습니다."),

    /*
    user
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    ;

//

    private final HttpStatus httpStatus;
    private final String message;
}