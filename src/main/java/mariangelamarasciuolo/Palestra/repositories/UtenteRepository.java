package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByEmail(String email);

}
