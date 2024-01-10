package mariangelamarasciuolo.Palestra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mariangelamarasciuolo.Palestra.Enum.Ruolo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "utenti")
public class Utente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    @JsonIgnore
    @OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
    private SchedaAnagrafica schedaAnagrafica;

    @JsonIgnore
    @OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
    private SchedaPalestra schedaPalestra;


    public Utente(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.ruolo = Ruolo.UTENTE;
    }

    public Utente() {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List a = List.of(new SimpleGrantedAuthority(this.ruolo.name()));
        System.out.println(a);
        return a;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return id == utente.id && Objects.equals(email, utente.email) && Objects.equals(password, utente.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, email, password);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
