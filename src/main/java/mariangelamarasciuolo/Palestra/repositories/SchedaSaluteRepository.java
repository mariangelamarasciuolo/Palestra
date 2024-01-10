package mariangelamarasciuolo.Palestra.repositories;

import mariangelamarasciuolo.Palestra.entities.SchedaSalute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedaSaluteRepository extends JpaRepository<SchedaSalute, Long> {
    @Query("SELECT s FROM SchedaSalute s WHERE s.schedaPalestra.utente.id = :idUtente")
    List<SchedaSalute> findByUtenteId(long idUtente);
}
