package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

public record ActorWriteDto
        (
                @NotNull
                @Size(min = 2, max = 20)
                String name,
                @NotNull
                @Size(min = 2, max = 20)
                String surname,
                @NotNull
                @Min(5)
                @Max(120)
                Integer age,

                Set<Long> filmsIds
        ) {
}
