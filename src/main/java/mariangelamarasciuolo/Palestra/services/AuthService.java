package mariangelamarasciuolo.Palestra.services;

import mariangelamarasciuolo.Palestra.Enum.Ruolo;
import mariangelamarasciuolo.Palestra.entities.Utente;
import mariangelamarasciuolo.Palestra.exceptions.BadRequestException;
import mariangelamarasciuolo.Palestra.exceptions.UnauthorizedException;
import mariangelamarasciuolo.Palestra.payloads.UtenteDTO;
import mariangelamarasciuolo.Palestra.payloads.UtenteLoginDTO;
import mariangelamarasciuolo.Palestra.repositories.UtenteRepository;
import mariangelamarasciuolo.Palestra.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PasswordEncoder bcrypt;

    public String autheticateUtente(UtenteLoginDTO body) {
        Utente utente = utenteService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), utente.getPassword())) {
            return jwtTools.createToken(utente);
        } else {
            throw new UnauthorizedException("credenziali non valide");
        }
    }

    public Utente saveUtente(UtenteDTO body) throws IOException {
        utenteRepository.findByEmail(body.email()).ifPresent(utente -> {
            throw new BadRequestException("L'email " + utente.getEmail() + "è già utilizzata!");
        });
        Utente newUtente = new Utente();
        newUtente.setNome(body.nome());
        newUtente.setCognome(body.cognome());
        newUtente.setEmail(body.email());
        newUtente.setPassword(bcrypt.encode(body.password()));
        newUtente.setRuolo(Ruolo.UTENTE);

        return utenteRepository.save(newUtente);
    }
}


