package com.sopt.sopkathonproduct.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NicknameValidator {

    private static final Pattern HANGUL_PATTERN = Pattern.compile("[가-힣]");
    private static final Pattern ENGLISH_PATTERN = Pattern.compile("[a-zA-Z]");
    private static final int MAX_HANGUL_LENGTH = 20;
    private static final int MAX_ENGLISH_LENGTH = 40;

    public static void validate(String nickname) throws MethodArgumentNotValidException {
        Matcher koreanMatcher = HANGUL_PATTERN.matcher(nickname);
        Matcher englishMatcher = ENGLISH_PATTERN.matcher(nickname);

        if (koreanMatcher.find()) {
            if (nickname.length() > MAX_HANGUL_LENGTH) {
                throw new MethodArgumentNotValidException(null, null);
            }
        } else if (englishMatcher.find()) {
            if (nickname.length() > MAX_ENGLISH_LENGTH) {
                throw new MethodArgumentNotValidException(null, null);
            }
        } else {
            throw new MethodArgumentNotValidException(null, null);
        }
    }
}
