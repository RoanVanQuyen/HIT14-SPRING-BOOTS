package com.example.baitaptuan6.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data@AllArgsConstructor@NoArgsConstructor
@Builder@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
    int code ;
    Object result ;
    String message ;
}
