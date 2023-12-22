package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


public record UtenteDTO(
        @NotEmpty(message = "Il nome non puo essere vuoto")
        String nome,
        @NotEmpty(message = "Il cognome non puo essere vuoto")
        String cognome,
        @NotEmpty(message = "email contatto non puo essere vuoto")
        @Pattern(regexp = "^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email non valida")
        String email,
        @NotEmpty(message = "La password è un campo obbligatorio!")
        String password) {
}
