package challenge.Goomer.infra.controller;

import challenge.Goomer.infra.dtos.CreateRestaurantDTO.CreateRestaurantRequest;
import challenge.Goomer.infra.service.CreateRestaurantUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class RestController {

    private final CreateRestaurantUseCaseImpl createRestaurantUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create (
            @RequestBody CreateRestaurantRequest createRestaurantRequest
            ){

        createRestaurantUseCase.
                execute(
                        createRestaurantRequest.getRestaurant(),
                        createRestaurantRequest.getAddress()
                );

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
