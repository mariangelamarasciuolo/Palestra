package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import mariangelamarasciuolo.Palestra.exceptions.NotFoundException;
import mariangelamarasciuolo.Palestra.payloads.SchedaPalestraDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaPalestraRepository;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SchedaPalestraService {
    @Autowired
    private SchedaPalestraRepository schedaPalestraRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public SchedaPalestra saveSchedaPalestra(SchedaPalestraDTO body) throws IOException {
        SchedaPalestra newSchedaPalestra = new SchedaPalestra();
        newSchedaPalestra.setDataDiNascita(body.dataDiNascita());
        newSchedaPalestra.setSesso(body.sesso());
        newSchedaPalestra.setAltezza(body.altezza());
        newSchedaPalestra.setPeso(body.peso());
        newSchedaPalestra.setUtente(utenteRepository.findById(body.utente_id()).get());
        return schedaPalestraRepository.save(newSchedaPalestra);
    }

    public SchedaPalestra findByIdSchedaPalestra(long idSchedaPalestra) throws NotFoundException {
        return schedaPalestraRepository.findById(idSchedaPalestra).orElseThrow(() -> new NotFoundException(idSchedaPalestra));
    }

    public SchedaPalestra findByIdUtente(long idUtente) {
        return schedaPalestraRepository.findByIdUtente(idUtente).orElseThrow(() -> new NotFoundException(idUtente));
    }

    public SchedaPalestra updateSchedaPalestraById(long id, SchedaPalestraDTO body) {
        SchedaPalestra schedaPalestra = schedaPalestraRepository.findById(id).orElseThrow(() -> new RuntimeException("Scheda anagrafica non trovata"));
        schedaPalestra.setSesso(body.sesso());
        schedaPalestra.setDataDiNascita(body.dataDiNascita());
        schedaPalestra.setPeso(body.peso());
        schedaPalestra.setAltezza(body.altezza());
        return schedaPalestraRepository.save(schedaPalestra);
    }

    public void deleteSchedaPalestraById(long id) {
        SchedaPalestra schedaPalestra = schedaPalestraRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        schedaPalestraRepository.delete(schedaPalestra);
    }
}
