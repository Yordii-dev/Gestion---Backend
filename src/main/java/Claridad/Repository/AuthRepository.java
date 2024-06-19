package Claridad.Repository;

import Claridad.Model.Alumno;
import Claridad.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);
}
