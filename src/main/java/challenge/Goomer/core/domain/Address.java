package challenge.Goomer.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Address (
        UUID id, String address, String addressComplement,
        String city, String state, String country, String zipcode,
        LocalDateTime createdAt, LocalDateTime updatedAt
){
}
