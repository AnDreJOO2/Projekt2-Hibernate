package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

public record FilmWriteDto
        (
                @NotNull
                @NotEmpty
                @NotBlank
                @Size(min = 2, max = 50)
                String name,
                @NotNull
                @Past
                @DateTimeFormat(pattern = "yyyy-MM-dd")
                LocalDate released,
                @Min(1)
                @Max(300)
                Long minutes,

                @Min(1)
                Long directorId,
                Set<Long> actorsIds
        ) {
}
