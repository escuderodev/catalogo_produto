package br.com.escuderodev.catalogo.domain.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByLogin(String login);
}
