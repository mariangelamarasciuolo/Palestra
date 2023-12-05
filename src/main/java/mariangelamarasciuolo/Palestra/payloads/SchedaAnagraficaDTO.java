package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;

public record SchedaAnagraficaDTO(
        @NotEmpty(message = "il campo dell'indirizzo non puo essere vuoto")
        String indirizzo,
        @NotEmpty(message = "il campo della città non puo essere vuoto")
        String citta,

        @NotEmpty(message = "il campo del cap della città non puo essere vuoto")
        String cap,
        @NotEmpty(message = "il campo della nazionalità non puo essere vuoto")
        String nazionalita,
        String telefonoFisso,
        @NotEmpty(message = "il campo del numero di cellulare non puo essere vuoto")
        String telefonoMobile) {
}
