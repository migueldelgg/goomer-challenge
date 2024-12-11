package challenge.Goomer.useCases;

import challenge.Goomer.infra.dtos.CreateRestaurantDTO.CreateAddressData;
import challenge.Goomer.infra.dtos.CreateRestaurantDTO.CreateRestaurantData;

public interface CreateRestaurantUseCase {

    public void execute (CreateRestaurantData createRestaurantData, CreateAddressData addressRequestBody);

}
