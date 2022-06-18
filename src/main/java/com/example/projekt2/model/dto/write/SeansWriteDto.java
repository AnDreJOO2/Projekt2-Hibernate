package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record SeansWriteDto
        (
                @NotNull
                Long roomId,
                @NotNull
                Long filmId,
                String language,
                @NotNull
                @DateTimeFormat(pattern = "yyyy-MM-dd")
                LocalDate dateOfSeans,
                @NotNull
                @DateTimeFormat(pattern = "HH:mm:ss")
                LocalTime startTime
        ) {
}
