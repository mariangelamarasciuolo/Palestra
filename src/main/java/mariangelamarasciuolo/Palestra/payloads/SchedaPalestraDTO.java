package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record SchedaPalestraDTO(

        @NotEmpty(message = "il campo della data di nascita non puo essere vuoto")
        LocalDate dataDiNascita,
        @NotEmpty(message = "Il campo del sesso non puo essere vuoto")
        String sesso,
        @NotEmpty(message = "il campo dell'altezza non puo essere vuoto")
        double altezza,
        @NotEmpty(message = "Il campo del peso non puo essere vuoto")
        double peso) {
}
