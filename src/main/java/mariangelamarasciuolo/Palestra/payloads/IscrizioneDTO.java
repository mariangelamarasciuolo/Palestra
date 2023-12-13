package mariangelamarasciuolo.Palestra.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record IscrizioneDTO(

        @NotNull(message = "il campo del pagamento non puo essere null")
        boolean pagamentoEffettuato,
        @NotNull(message = "l'Id della scheda palestra non può essere null")
        Long schedaPalestra_id,

        @NotEmpty(message = "l'abbonamento è un campo obbligatorio")
        String abbonamento) {
}
