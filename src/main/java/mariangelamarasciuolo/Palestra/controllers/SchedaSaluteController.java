package mariangelamarasciuolo.Palestra.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import mariangelamarasciuolo.Palestra.entities.SchedaSalute;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.SchedaSaluteDTO;
import mariangelamarasciuolo.Palestra.security.JWTTools;
import mariangelamarasciuolo.Palestra.services.SchedaSaluteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/scheda_salute")
public class SchedaSaluteController {
    @Autowired
    SchedaSaluteService schedaSaluteService;
    @Autowired
    private JWTTools jwtTools;

    @Hidden
    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public SchedaSalute saveSchedaSalute(@RequestBody @Validated SchedaSaluteDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return schedaSaluteService.saveSchedaSalute(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/{idSchedaSalute}")
    public SchedaSalute findByIdSchedaSalute(@PathVariable long idSchedaSalute) {
        return schedaSaluteService.findByIdSchedaSalute(idSchedaSalute);
    }

    @GetMapping
    public List<SchedaSalute> findByIdSchedaSalute(@RequestHeader(name = "Authorization", required = false) String token) {
        System.out.println(token);
        Long uId = jwtTools.getUserId(token);
        System.out.println("uId " + uId);
        return schedaSaluteService.findByUtenteId(uId);
    }

    @PutMapping("{idSchedaSalute}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SchedaSalute updateSchedaSaluteById(@PathVariable @Parameter(description = "id della scheda salute da modificare") long idSchedaSalute, @RequestBody @Validated SchedaSaluteDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return schedaSaluteService.updateSchedaSaluteById(idSchedaSalute, body);
        }
    }

    @DeleteMapping("/{idSchedaSalute}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSchedaSaluteById(@PathVariable long idSchedaSalute) {
        schedaSaluteService.deleteSchedaSaluteById(idSchedaSalute);
    }
}
