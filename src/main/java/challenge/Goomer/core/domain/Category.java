package challenge.Goomer.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Category (
        UUID id, String name,
        LocalDateTime createdAt, LocalDateTime updatedAt
){
}
