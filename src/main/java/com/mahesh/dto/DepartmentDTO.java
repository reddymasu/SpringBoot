package com.mahesh.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO  {

    private Long id;
    @NotNull(message = "department id can not be blank cannot be blank")
    @Max(value = 100, message = "department id cannot be greater than 100")
    @Min(value = 10, message = "department id cannot be less than 10")
    private Long departmentid;
    @NotBlank(message = "department title cannot be blank")
    @Size(min = 3, max = 10, message = "Number of characters in title should be in the range: [3, 10]")
    private String title;
    private Boolean isActive;
    @PastOrPresent(message = "cretaedAt field in Department cannot be in the future")
    private LocalDate createdAt;


}
