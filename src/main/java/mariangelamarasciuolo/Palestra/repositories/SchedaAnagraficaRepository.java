package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaAnagrafica;
import mariangelamarasciuolo.Palestra.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchedaAnagraficaRepository extends JpaRepository<SchedaAnagrafica, Long> {

    SchedaAnagrafica findByUtente(Utente u);

    @Query("SELECT s FROM SchedaAnagrafica s WHERE s.utente.id = :idUtente")
    Optional<SchedaAnagrafica> findByIdUtente(long idUtente);
}
