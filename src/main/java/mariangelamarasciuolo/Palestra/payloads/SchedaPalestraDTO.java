package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SchedaPalestraDTO(


        LocalDate dataDiNascita,
        @NotEmpty(message = "Il campo del sesso non puo essere vuoto")
        String sesso,
        @NotNull(message = "il campo dell'altezza non puo essere null")
        double altezza,
        @NotNull(message = "Il campo del peso non puo essere null")
        int peso,
        @NotNull(message = "l'Id dell'utente non può essere null")
        Long utente_id) {
}
