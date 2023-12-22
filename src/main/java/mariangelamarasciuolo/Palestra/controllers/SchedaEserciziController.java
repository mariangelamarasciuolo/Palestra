package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.SchedaEsercizi;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.SchedaEserciziDTO;
import mariangelamarasciuolo.Palestra.services.SchedaEserciziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/scheda_esercizi")
public class SchedaEserciziController {
    @Autowired
    private SchedaEserciziService schedaEserciziService;

    @Hidden
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SchedaEsercizi saveSchedaEsercizi(@RequestBody @Validated SchedaEserciziDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return schedaEserciziService.saveSchedaEsercizi(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/{idSchedaEsercizi}")
    public SchedaEsercizi findByIdSchedaEsercizi(@PathVariable long idSchedaEsercizi) {
        return schedaEserciziService.findByIdSchedaEsercizi(idSchedaEsercizi);
    }

    @PutMapping("{idSchedaEsercizi}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SchedaEsercizi updateSchedaEserciziById(@PathVariable @Parameter(description = "id della scheda esercizi da modificare") long idSchedaEsercizi, @RequestBody @Validated SchedaEserciziDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return schedaEserciziService.updateSchedaEserciziById(idSchedaEsercizi, body);
        }
    }

    @DeleteMapping("/{idSchedaEsercizi}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSchedaEserciziById(@PathVariable long idSchedaEsercizi) {
        schedaEserciziService.deleteSchedaEserciziById(idSchedaEsercizi);
    }
}
