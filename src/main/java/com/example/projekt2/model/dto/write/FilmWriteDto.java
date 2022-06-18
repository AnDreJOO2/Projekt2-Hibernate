package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

public record FilmWriteDto
        (
                @NotNull
                @Size(min = 2, max = 50)
                String name,
                @NotNull
                @DateTimeFormat(pattern = "yyyy-MM-dd")
                LocalDate released,
                @Min(1)
                @Max(300)
                Long minutes,
                @NotNull
                Long directorId,
                Set<Long> actorsIds
        ) {
}
