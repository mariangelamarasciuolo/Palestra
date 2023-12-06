package mariangelamarasciuolo.Palestra.payloads;

import io.swagger.v3.oas.annotations.Hidden;

import java.util.Date;

@Hidden
public record ErrorsResponseDTO(String message, Date timestamp) {
}
