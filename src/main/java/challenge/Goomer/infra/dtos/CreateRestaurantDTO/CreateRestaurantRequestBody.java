package challenge.Goomer.infra.dtos.CreateRestaurantDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateRestaurantRequestBody {

    @JsonProperty(value = "restaurant_name")
    @NotBlank(message = "The field restaurant name is required.")
    private String name;

    @NotNull(message = "This field is required, if your restaurant does not have a photo, send it blank.")
    private String photo;

    private String complement;

    @NotBlank(message = "The zip code is required.")
    @Pattern(regexp = "^\\d{8}$", message = "The zip code must contain exactly 8 digits.")
    private String zipcode;
}
