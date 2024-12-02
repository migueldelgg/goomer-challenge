package challenge.Goomer.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Product (
        UUID id, String name, Double price, String photo,
        LocalDateTime createdAt, LocalDateTime updatedAt
){
}
