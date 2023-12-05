package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SchedaEserciziDTO(
        @NotEmpty(message = "Il campo del nome della scheda esercizi non puo essere vuoto")
        String nomeSchedaEsercizi,
        @NotNull(message = "il campo della descrizione della scheda esercizi non puo essere vuoto")
        String descrizione) {
}
