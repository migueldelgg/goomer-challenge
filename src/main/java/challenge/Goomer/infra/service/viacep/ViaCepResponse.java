package challenge.Goomer.infra.service.viacep;

public record ViaCepResponse (
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        String service) {
}
