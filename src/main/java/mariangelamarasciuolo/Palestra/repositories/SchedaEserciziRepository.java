package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaEsercizi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedaEserciziRepository extends JpaRepository<SchedaEsercizi, Long> {
    @Query("SELECT s FROM SchedaEsercizi s WHERE s.schedaPalestra.utente.id = :idUtente")
    List<SchedaEsercizi> findByUtenteId(long idUtente);

}
