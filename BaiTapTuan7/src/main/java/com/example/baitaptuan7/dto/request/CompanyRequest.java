package com.example.baitaptuan7.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRequest {
    String companyName ;
}
