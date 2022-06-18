package com.example.projekt2.model.dto.write;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

public record RoomWriteDto
        (
                @Min(20)
                @Max(200)
                @NotNull
                Integer placeNumber,

                Boolean airConditioning,

                Set<Long> seansIds
        ) {
}
