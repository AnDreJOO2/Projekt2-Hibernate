package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public record CinemaWriteDto
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
                String city,
                @NotNull
                @NotEmpty
                @NotBlank
                @Size(min = 2, max = 20)
                String street,
                @NotNull
                @NotEmpty
                @NotBlank
                @Size(min = 1, max = 20)
                String number,

                Set<Long> roomsIds
        ) {
}
