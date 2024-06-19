package Claridad.Repository;
import Claridad.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CursoRepository  extends JpaRepository<Curso, Long> {
}
