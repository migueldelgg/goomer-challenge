package challenge.Goomer.infra.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CreateAddressData(
        @NotNull @Length(max = 8)
        String zipcode,
        String number,
        String complement,
        String country
) {}
