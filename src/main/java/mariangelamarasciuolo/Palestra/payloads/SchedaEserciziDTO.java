package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SchedaEserciziDTO(

        LocalDate dataSchedaEsercizi,
        @NotEmpty(message = "Il campo del nome della scheda esercizi non puo essere vuoto")
        String nomeSchedaEsercizi,
        @NotNull(message = "il campo della descrizione della scheda esercizi non puo essere vuoto")
        String descrizione,


        @NotNull(message = "l'Id dell'utente non può essere null")
        Long schedaPalestra_id) {
}
