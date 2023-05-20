package com.sopt.sopkathonproduct.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    HEALTH(HttpStatus.OK, "서버가 정상적으로 작동하고 있습니다."),

    /**
     * 200 OK
     */
    READ_POST_SUCCESS(HttpStatus.OK, "게시글 상세 조회 성공"),
    CREATE_POST_SUCCESS(HttpStatus.OK, "게시글 업로드 성공"),
    READ_RANKING_LIST_SUCCESS(HttpStatus.OK, "게시글 랭킹 리스트 조회 성공"),
    UPDATE_RANKING_SUCCESS(HttpStatus.OK, "랭킹 업데이트 성공"),
    READ_POST_LIST_SUCCESS(HttpStatus.OK, "게시글 토너먼트 리스트 조회 성공");

    private final HttpStatus httpStatus;
    private final String message;
}