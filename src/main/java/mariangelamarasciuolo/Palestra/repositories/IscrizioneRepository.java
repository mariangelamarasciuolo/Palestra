package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.Iscrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {
    Optional<Iscrizione> findBySchedaPalestraId(long schedaPalestraId);

    @Query("SELECT s FROM Iscrizione s WHERE s.schedaPalestra.utente.id = :idUtente")
    List<Iscrizione> findByUtenteId(long idUtente);

}
