package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaAnagrafica;
import mariangelamarasciuolo.Palestra.exceptions.NotFoundException;
import mariangelamarasciuolo.Palestra.payloads.SchedaAnagraficaDTO;
import mariangelamarasciuolo.Palestra.repositories.SchedaAnagraficaRepository;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SchedaAnagraficaService {
    @Autowired
    private SchedaAnagraficaRepository schedaAnagraficaRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public SchedaAnagrafica saveSchedaAnagrafica(SchedaAnagraficaDTO body) throws IOException {

        SchedaAnagrafica newSchedaAnagrafica = new SchedaAnagrafica();
        newSchedaAnagrafica.setCitta(body.citta());
        newSchedaAnagrafica.setCap(body.cap());
        newSchedaAnagrafica.setIndirizzo(body.indirizzo());
        newSchedaAnagrafica.setNazionalita(body.nazionalita());
        newSchedaAnagrafica.setTelefonoFisso(body.telefonoFisso());
        newSchedaAnagrafica.setTelefonoMobile(body.telefonoMobile());
        newSchedaAnagrafica.setUtente(utenteRepository.findById(body.utente_id()).get());
        return schedaAnagraficaRepository.save(newSchedaAnagrafica);
    }

    public SchedaAnagrafica findByIdSchedaAnagrafica(long idSchedaAnagrafica) throws NotFoundException {
        return schedaAnagraficaRepository.findById(idSchedaAnagrafica).orElseThrow(() -> new NotFoundException(idSchedaAnagrafica));
    }

    public SchedaAnagrafica updateSchedaAnagraficaById(long id, SchedaAnagraficaDTO body) {
        SchedaAnagrafica schedaAnagrafica = schedaAnagraficaRepository.findById(id).orElseThrow(() -> new RuntimeException("Scheda anagrafica non trovata"));
        schedaAnagrafica.setCitta(body.citta());
        schedaAnagrafica.setIndirizzo(body.indirizzo());
        schedaAnagrafica.setCap(body.cap());
        schedaAnagrafica.setTelefonoMobile(body.telefonoMobile());
        schedaAnagrafica.setTelefonoFisso(body.telefonoFisso());
        return schedaAnagraficaRepository.save(schedaAnagrafica);
    }

    public void deleteSchedaAnagraficaById(long id) {
        SchedaAnagrafica schedaAnagrafica = schedaAnagraficaRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        schedaAnagraficaRepository.delete(schedaAnagrafica);
    }

}
