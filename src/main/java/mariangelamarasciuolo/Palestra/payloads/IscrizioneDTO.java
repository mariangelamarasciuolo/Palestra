package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotNull;
import mariangelamarasciuolo.Palestra.Enum.Abbonamento;
import mariangelamarasciuolo.Palestra.Enum.ValueOfEnum;

import java.time.LocalDate;

public record IscrizioneDTO(
        @NotNull(message = "la data dell'iscrizione non puo essere null")
        LocalDate dataIscrizione,

        @NotNull(message = "la data della scadenza non puo essere null")
        LocalDate dataScadenza,
        @NotNull(message = "il campo del pagamento non puo essere null")
        boolean pagamentoEffettuato,

        @NotNull(message = "Il tipo di abbonamento non può essere nulla")
        @ValueOfEnum(enumClass = Abbonamento.class, message = "Il tipo di abbonamento deve essere MENSILE, SEMESTRALE o ANNUALE")
        String abbonamento
) {
}
