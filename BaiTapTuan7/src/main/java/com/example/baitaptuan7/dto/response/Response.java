package com.example.baitaptuan7.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor@NoArgsConstructor
@Data@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
    int code ;
    Object result ;
    String message ;
}
