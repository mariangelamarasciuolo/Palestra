package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.SchedaPalestraDTO;
import mariangelamarasciuolo.Palestra.services.SchedaPalestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/schedaPalestra")
public class SchedaPalestraController {
    @Autowired
    SchedaPalestraService schedaPalestraService;


    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public SchedaPalestra saveSchedaPalestra(@RequestBody @Validated SchedaPalestraDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return schedaPalestraService.saveSchedaPalestra(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/{idSchedaPalestra}")
    public SchedaPalestra findByIdSchedaPalestra(@PathVariable long idSchedaPalestra) {
        return schedaPalestraService.findByIdSchedaPalestra(idSchedaPalestra);
    }

    @PutMapping("{idSchedaPalestra}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SchedaPalestra updateSchedaPalestraById(@PathVariable @Parameter(description = "id della scheda anagrafica da modificare") long idSchedaPalestra, @RequestBody @Validated SchedaPalestraDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return schedaPalestraService.updateSchedaPalestraById(idSchedaPalestra, body);
        }
    }

    @DeleteMapping("/{idSchedaPalestra}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSchedaPalestraById(@PathVariable long idSchedaPalestra) {
        schedaPalestraService.deleteSchedaPalestraById(idSchedaPalestra);
    }
}
