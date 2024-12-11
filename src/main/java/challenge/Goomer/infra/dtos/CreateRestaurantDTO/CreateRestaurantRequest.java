package challenge.Goomer.infra.dtos.CreateRestaurantDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRestaurantRequest {

    @NotNull
    private CreateRestaurantData restaurant;

    @NotNull
    private CreateAddressData address;
}
