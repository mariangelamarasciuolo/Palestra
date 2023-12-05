package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record SchedaSaluteDTO(
        @NotEmpty(message = "il campo della data della scheda salute non puo essere vuoto")
        LocalDate dataSchedaSalute,

        @NotEmpty(message = "il campo delle patologie non puo essere vuoto")
        String patologie,
        String note) {
}
