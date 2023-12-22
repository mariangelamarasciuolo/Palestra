package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import mariangelamarasciuolo.Palestra.entities.Utente;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.UtenteDTO;
import mariangelamarasciuolo.Palestra.payloads.UtenteLoginDTO;
import mariangelamarasciuolo.Palestra.payloads.UtenteLoginSuccessDTO;
import mariangelamarasciuolo.Palestra.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "API gestione utenti")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public UtenteLoginSuccessDTO login(@RequestBody UtenteLoginDTO body) {
        return new UtenteLoginSuccessDTO(authService.autheticateUtente(body));
    }

    @Hidden
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente saveUser(@RequestBody @Validated UtenteDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return authService.saveUtente(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
