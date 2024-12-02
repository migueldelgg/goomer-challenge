package challenge.Goomer.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Restaurant (
        UUID id, String name, String photo,
        LocalDateTime createdAt, LocalDateTime updatedAt
) {
}
