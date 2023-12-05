package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record IscrizioneDTO(
        @NotNull(message = "la data dell'iscrizione non puo essere null")
        LocalDate dataIscrizione,

        @NotNull(message = "la data della scadenza non puo essere null")
        LocalDate dataScadenza,
        @NotNull(message = "il campo del pagamento non puo essere null")
        boolean pagamentoEffettuato) {
}
