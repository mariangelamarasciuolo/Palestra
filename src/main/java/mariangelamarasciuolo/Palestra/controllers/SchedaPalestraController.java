package mariangelamarasciuolo.Palestra.controllers;

import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.payloads.SchedaPalestraDTO;
import mariangelamarasciuolo.Palestra.services.SchedaPalestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
