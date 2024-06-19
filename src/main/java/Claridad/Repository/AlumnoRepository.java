package Claridad.Repository;

import Claridad.Model.Alumno;
import Claridad.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AlumnoRepository  extends JpaRepository<Alumno, Long> {
    //Optional<Usuario> findById_usuario(Integer id_usuario);
}
