package br.com.escuderodev.catalogo.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Users")
@Table(name = "users")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "iduser")
public class Users implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String login;
    private String password;

    public Users(UserRegistrationData data) {
        this.iduser = data.iduser();
        this.login = data.login();
        this.password = data.password();
    }

    public Users() {
    }

    public void updateData(UserUpdateData data) {
        this.login = data.login();
        this.password = data.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
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
