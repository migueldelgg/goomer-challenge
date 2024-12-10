package challenge.Goomer.infra.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CreateRestaurantData {

    @NotNull
    private String name;

    private String photo;

    public CreateRestaurantData() {
    }

    public CreateRestaurantData(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateRestaurantData that = (CreateRestaurantData) o;
        return Objects.equals(name, that.name) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, photo);
    }
}
