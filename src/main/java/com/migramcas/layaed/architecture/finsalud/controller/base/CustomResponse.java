package com.migramcas.layaed.architecture.finsalud.controller.base;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse {

    private LocalDateTime timestamp;
    private Integer httpCode;
    private String message;
    private Object payload;

}
