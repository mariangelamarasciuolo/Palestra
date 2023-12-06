package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.entities.Utente;
import mariangelamarasciuolo.Palestra.exceptions.NotFoundException;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;


    public Utente findByEmail(String email) {
        return utenteRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("utente con email" + email + "non trovato"));
    }

    public Utente findById(long id) throws NotFoundException {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

}
