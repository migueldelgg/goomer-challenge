package challenge.Goomer.infra.service;

import challenge.Goomer.infra.dtos.CreateRestaurantDTO.CreateAddressData;
import challenge.Goomer.infra.dtos.CreateRestaurantDTO.CreateRestaurantData;
import challenge.Goomer.infra.entity.AddressEntity;
import challenge.Goomer.infra.entity.RestaurantEntity;
import challenge.Goomer.infra.repository.AddressRepository;
import challenge.Goomer.infra.repository.RestaurantRepository;
import challenge.Goomer.infra.service.viacep.ViaCepHttpCall;
import challenge.Goomer.useCases.CreateRestaurantUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Service
public class CreateRestaurantUseCaseImpl implements CreateRestaurantUseCase {

    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;
    private final ViaCepHttpCall viaCepHttpCall;

    @Override
    @Transactional
    public void execute(CreateRestaurantData restaurantInput, CreateAddressData addressInput) {

        if(isRestaurantAlreadyExisting(restaurantInput)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "A restaurant with the given name already exists."
            );
        }

        var viaCepResponse = viaCepHttpCall.execute(addressInput.zipcode());
        String addressConstructor = viaCepResponse.street() + ", "+ addressInput.number();
        final var restaurant = RestaurantEntity.builder()
                .name(restaurantInput.getName())
                .photo(restaurantInput.getPhoto())
                .build();

        final var address = AddressEntity.builder()
                .address(addressConstructor)
                .addressComplement(addressInput.complement())
                .city(viaCepResponse.city())
                .state(viaCepResponse.state())
                .country(addressInput.country())
                .zipcode(addressInput.zipcode())
                .restaurant(restaurant)
                .build();

        restaurantRepository.saveAndFlush(restaurant);
        addressRepository.saveAndFlush(address);
    }

    private boolean isRestaurantAlreadyExisting (
            CreateRestaurantData createRestaurantData
    ) {
        return restaurantRepository
                .getRestaurantByName(createRestaurantData
                        .getName()).isPresent();
    }

}
