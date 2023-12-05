package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mariangelamarasciuolo.Palestra.Enum.Ruolo;
import mariangelamarasciuolo.Palestra.Enum.ValueOfEnum;

public record UtenteDTO(
        @NotEmpty(message = "Il nome non puo essere vuoto")
        String nome,
        @NotEmpty(message = "Il cognome non puo essere vuoto")
        String cognome,
        @NotEmpty(message = "email contatto non puo essere vuoto")
        @Pattern(regexp = "^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email non valida")
        String email,
        @NotEmpty(message = "La password è un campo obbligatorio!")
        String password,
        @NotNull(message = "Il Ruolo non puo essere null")
        @ValueOfEnum(enumClass = Ruolo.class, message = "Sei Admin o Utente?")
        String tipoCliente) {
}
