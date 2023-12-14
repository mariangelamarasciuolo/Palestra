package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.Utente;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.UtenteDTO;
import mariangelamarasciuolo.Palestra.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping("/{id}")
    public Utente findById(@PathVariable long id) {
        return utenteService.findById(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente updateUtenteById(@PathVariable @Parameter(description = "id del cliente da modificare") long id, @RequestBody @Validated UtenteDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return utenteService.updateById(id, body);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUtenteById(@PathVariable long id) {
        utenteService.deleteById(id);
    }


}
