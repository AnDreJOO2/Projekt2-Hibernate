package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public record CinemaWriteDto
        (
                @NotNull
                @Size(min = 2, max = 20)
                String name,
                @NotNull
                @Size(min = 2, max = 20)
                String city,
                @NotNull
                @Size(min = 2, max = 20)
                String street,
                @NotNull
                @Size(min = 1, max = 20)
                String number
        ) {
}
