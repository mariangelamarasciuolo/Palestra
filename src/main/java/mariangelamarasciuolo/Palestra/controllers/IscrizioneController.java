package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.Iscrizione;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.IscrizioneDTO;
import mariangelamarasciuolo.Palestra.security.JWTTools;
import mariangelamarasciuolo.Palestra.services.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/iscrizione")
public class IscrizioneController {
    @Autowired
    private IscrizioneService iscrizioneService;
    @Autowired
    private JWTTools jwtTools;

    @Hidden
    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/{idIscrizione}")
    public Iscrizione findByIdIscrizione(@PathVariable long idIscrizione) {
        return iscrizioneService.findByIdIscrizione(idIscrizione);
    }

    @GetMapping
    public List<Iscrizione> findByIdIscrizione(@RequestHeader(name = "Authorization", required = false) String token) {
        System.out.println(token);
        Long uId = jwtTools.getUserId(token);
        System.out.println("uId " + uId);
        return iscrizioneService.findByUtenteId(uId);
    }

    @PutMapping("{idIscrizione}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Iscrizione updateIscrizioneById(@PathVariable @Parameter(description = "id dell'iscrizione da modificare") long idIscrizione, @RequestBody @Validated IscrizioneDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return iscrizioneService.updateIscrizioneById(idIscrizione, body);
        }
    }

    @DeleteMapping("/{idIscrizione}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteIscrizioneById(@PathVariable long idIscrizione) {
        iscrizioneService.deleteIscrizioneById(idIscrizione);
    }
}
