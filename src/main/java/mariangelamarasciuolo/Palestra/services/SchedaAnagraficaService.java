package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.SchedaAnagrafica;
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

}
