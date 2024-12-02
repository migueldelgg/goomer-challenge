package challenge.Goomer.core.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record PromotionProduct (
        UUID id, String description, Double promotional_price,
        String dayofweek, LocalTime start, Integer duration,
        LocalDateTime createdAt, LocalDateTime updatedAt
){
}
