package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaPalestra;
import mariangelamarasciuolo.Palestra.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchedaPalestraRepository extends JpaRepository<SchedaPalestra, Long> {
    SchedaPalestra findByUtente(Utente u);

    @Query("SELECT s FROM SchedaPalestra s WHERE s.utente.id = :idUtente")
    Optional<SchedaPalestra> findByIdUtente(long idUtente);
}
