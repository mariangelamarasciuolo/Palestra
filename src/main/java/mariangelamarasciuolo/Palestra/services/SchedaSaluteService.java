package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaSalute;
import mariangelamarasciuolo.Palestra.exceptions.NotFoundException;
import mariangelamarasciuolo.Palestra.payloads.SchedaSaluteDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaPalestraRepository;
import mariangelamarasciuolo.Palestra.repositories.SchedaSaluteRepository;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SchedaSaluteService {
    @Autowired
    private SchedaSaluteRepository schedaSaluteRepository;

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private SchedaPalestraRepository schedaPalestraRepository;


    public SchedaSalute saveSchedaSalute(SchedaSaluteDTO body) throws IOException {

        SchedaSalute newSchedaSalute = new SchedaSalute();
        newSchedaSalute.setDataSchedaSalute(body.dataSchedaSalute());
        newSchedaSalute.setPatologie(body.patologie());
        newSchedaSalute.setNote(body.note());
        newSchedaSalute.setSchedaPalestra(schedaPalestraRepository.findById(body.schedaPalestra_id()).get());
        return schedaSaluteRepository.save(newSchedaSalute);

    }

    public SchedaSalute findByIdSchedaSalute(long idSchedaSalute) throws NotFoundException {
        return schedaSaluteRepository.findById(idSchedaSalute).orElseThrow(() -> new NotFoundException(idSchedaSalute));
    }

    public List<SchedaSalute> findByUtenteId(long idUtente) {
        return schedaSaluteRepository.findByUtenteId(idUtente);
    }

    public SchedaSalute updateSchedaSaluteById(long idSchedaSalute, SchedaSaluteDTO body) {
        SchedaSalute schedaSalute = schedaSaluteRepository.findById(idSchedaSalute).orElseThrow(() -> new RuntimeException("Scheda salute non trovata"));
        schedaSalute.setNote(body.note());
        schedaSalute.setDataSchedaSalute(body.dataSchedaSalute());
        schedaSalute.setPatologie(body.patologie());
        return schedaSaluteRepository.save(schedaSalute);
    }

    public void deleteSchedaSaluteById(long idSchedaSalute) {
        SchedaSalute schedaSalute = schedaSaluteRepository.findById(idSchedaSalute).orElseThrow(() -> new NotFoundException(idSchedaSalute));
        schedaSaluteRepository.delete(schedaSalute);
    }
}
