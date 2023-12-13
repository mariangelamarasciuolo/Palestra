package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import mariangelamarasciuolo.Palestra.entities.Iscrizione;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.IscrizioneDTO;
import mariangelamarasciuolo.Palestra.services.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/iscrizione")
public class IscrizioneController {
    @Autowired
    private IscrizioneService iscrizioneService;

    @Hidden
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Iscrizione saveIscrizione(@RequestBody @Validated IscrizioneDTO body, BindingResult validation) {

        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {

            try {
                System.out.println("prima");
                return iscrizioneService.saveIscrizione(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
