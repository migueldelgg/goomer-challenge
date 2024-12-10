package challenge.Goomer.useCases;

import challenge.Goomer.infra.dtos.CreateAddressData;
import challenge.Goomer.infra.dtos.CreateRestaurantData;

public interface CreateRestaurantUseCase {

    public void execute (CreateRestaurantData createRestaurantData, CreateAddressData addressRequestBody);

}
