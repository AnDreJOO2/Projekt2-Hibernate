package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;

import javax.validation.constraints.*;
import java.util.Set;

public record DirectorWriteDto
        (
                @NotNull
                @NotEmpty
                @NotBlank
                @Size(min = 2, max = 20)
                String name,
                @NotNull
                @NotEmpty
                @NotBlank
                @Size(min = 2, max = 20)
                String surname,
                @Min(5)
                @Max(120)
                Integer age,
                Set<Long> filmsIds
        ) {
}
