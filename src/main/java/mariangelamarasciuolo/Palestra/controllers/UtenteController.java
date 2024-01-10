package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.Utente;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.UtenteDTO;
import mariangelamarasciuolo.Palestra.security.JWTTools;
import mariangelamarasciuolo.Palestra.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private JWTTools jwtTools;

    @GetMapping("/{idUtente}")
    public Utente findById(@PathVariable long idUtente) {
        return utenteService.findById(idUtente);
    }

    @GetMapping
    public Utente findById(@RequestHeader(name = "Authorization", required = false) String token) {
        System.out.println(token);
        Long idUtente = jwtTools.getUserId(token);
        return utenteService.findById(idUtente);
    }


    @PutMapping("/{idUtente}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente updateUtenteById(@PathVariable @Parameter(description = "id del cliente da modificare") long idUtente, @RequestBody @Validated UtenteDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return utenteService.updateById(idUtente, body);
        }
    }

    @DeleteMapping("/{idUtente}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUtenteById(@PathVariable long idUtente) {
        utenteService.deleteById(idUtente);
    }


}
