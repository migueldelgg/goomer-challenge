package challenge.Goomer.infra.controller;

import challenge.Goomer.infra.entity.RestaurantEntity;
import challenge.Goomer.infra.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/criar")
    public ResponseEntity<String> creating() {
        var entidade = new RestaurantEntity();
        entidade.setName("Example Restaurant");
        entidade.setPhoto("example.jpg");
        restaurantRepository.save(entidade);
        var id = entidade.getId();
        var created = entidade.getCreatedAt();
        var updated = entidade.getUpdatedAt();
        String message = String.format("Restaurant created with ID: %s, criado as: %s, atualizado as: %s", id, created, updated);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/encontrar")
    public ResponseEntity<Object> encontrar() {
        return ResponseEntity.ok(restaurantRepository.findAll());
    }
}
