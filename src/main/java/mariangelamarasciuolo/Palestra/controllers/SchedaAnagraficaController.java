package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.SchedaAnagrafica;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.SchedaAnagraficaDTO;
import mariangelamarasciuolo.Palestra.services.SchedaAnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/scheda_anagrafica")
public class SchedaAnagraficaController {
    @Autowired
    private SchedaAnagraficaService schedaAnagraficaService;

    @Hidden
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SchedaAnagrafica saveSchedaAnagrafica(@RequestBody @Validated SchedaAnagraficaDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return schedaAnagraficaService.saveSchedaAnagrafica(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/{idSchedaAnagrafica}")
    public SchedaAnagrafica findByIdSchedaAnagrafica(@PathVariable long idSchedaAnagrafica) {
        return schedaAnagraficaService.findByIdSchedaAnagrafica(idSchedaAnagrafica);
    }

    @PutMapping("/{idSchedaAnagrafica}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SchedaAnagrafica updateSchedaAnagraficaById(@PathVariable @Parameter(description = "id della scheda anagrafica da modificare") long idSchedaAnagrafica, @RequestBody @Validated SchedaAnagraficaDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return schedaAnagraficaService.updateSchedaAnagraficaById(idSchedaAnagrafica, body);
        }
    }

    @DeleteMapping("/{idSchedaAnagrafica}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSchedaAnagraficaById(@PathVariable long idSchedaAnagrafica) {
        schedaAnagraficaService.deleteSchedaAnagraficaById(idSchedaAnagrafica);
    }
}
