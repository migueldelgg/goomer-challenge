package challenge.Goomer.infra.dtos;

public record ViaCepResponse (
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        String service) {
}
