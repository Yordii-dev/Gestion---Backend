package Claridad.Controller;

import Claridad.Model.Curso;
import Claridad.Repository.CursoRepository;
import Claridad.Response.FailResponse;
import Claridad.Response.Response;
import Claridad.Response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cursos")
@CrossOrigin(origins = "*")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            curso.setNombre(cursoDetails.getNombre());
            curso.setModalidad(cursoDetails.getModalidad());
            curso.setDescripcion(cursoDetails.getDescripcion());
            curso.setDuracion(cursoDetails.getDuracion());
            curso.setRequisitos_previos(cursoDetails.getRequisitos_previos());
            Curso updatedCurso = cursoRepository.save(curso);
            return ResponseEntity.ok(updatedCurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCurso(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            cursoRepository.deleteById(id);
            Response response = new SuccessResponse("Curso eliminado correctamente");
            return ResponseEntity.ok(response);
        } else {
            Response response = new FailResponse("Curso no eliminado", "No se pudo eliminar el curso.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
