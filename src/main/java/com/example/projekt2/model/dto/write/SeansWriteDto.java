package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

public record SeansWriteDto
        (

                Long roomId,
                Long filmId,
                @NotNull
                @NotEmpty
                @NotBlank
                @Size(min = 2, max = 50)
                String language,
                @NotNull
                @PastOrPresent
                @DateTimeFormat(pattern = "yyyy-MM-dd")
                LocalDate dateOfSeans,
                @NotNull
                @PastOrPresent
                @DateTimeFormat(pattern = "HH:mm:ss")
                LocalTime startTime
        ) {
}
