package br.com.escuderodev.catalogo.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Users")
@Table(name = "users")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "iduser")
public class Users {
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
}
