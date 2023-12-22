package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SchedaSaluteDTO(

        LocalDate dataSchedaSalute,

        String patologie,
        String note,
        @NotNull(message = "l'Id della scheda palestra non può essere null")
        Long schedaPalestra_id) {
}
