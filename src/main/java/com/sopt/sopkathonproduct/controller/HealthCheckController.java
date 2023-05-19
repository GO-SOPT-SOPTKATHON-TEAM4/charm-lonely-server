package com.sopt.sopkathonproduct.controller;

import com.sopt.sopkathonproduct.common.dto.ApiResponseDto;
import com.sopt.sopkathonproduct.exception.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<ApiResponseDto> healthCheck() {
        return ResponseEntity.ok(ApiResponseDto.success(SuccessStatus.HEALTH));
    }
}

