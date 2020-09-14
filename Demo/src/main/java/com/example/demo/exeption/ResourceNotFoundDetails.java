package com.example.demo.exeption;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResourceNotFoundDetails {

    private String title;
    private String detail;
    private String developerMessage;
    private LocalDateTime timestamp;
    private int status;
}
