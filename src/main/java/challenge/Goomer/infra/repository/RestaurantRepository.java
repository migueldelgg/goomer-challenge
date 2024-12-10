package challenge.Goomer.infra.repository;

import challenge.Goomer.infra.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, UUID> {

    @Query(value = "SELECT name FROM restaurant WHERE name = :inputName", nativeQuery = true)
    Optional<String> getRestaurantByName(String inputName);

}
