package challenge.Goomer.infra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    private String photo;

    @Column(insertable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    @Column(insertable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "updated_at")
    private LocalDateTime updatedAt;

    public RestaurantEntity() {
    }
}
