package com.example.projekt2.model.dto.write;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

public record RoomWriteDto
        (
                @Min(20)
                @Max(200)
                Integer placeNumber,

                Boolean airConditioning,

                Set<Long> seansIds
        ) {
}
