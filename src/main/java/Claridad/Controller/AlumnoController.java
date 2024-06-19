package Claridad.Controller;

import Claridad.Model.Alumno;
import Claridad.Model.Curso;
import Claridad.Repository.AlumnoRepository;
import Claridad.Response.ErrorResponse;
import Claridad.Response.FailResponse;
import Claridad.Response.Response;
import Claridad.Response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")

@CrossOrigin(origins = "*")

public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> getAllAlumnos(){
        return alumnoRepository.findAll();
    }

    /*
    @GetMapping("/byIdUser{id_usuario}")
    public ResponseEntity<Response> getAlumnoByIdUser(@PathVariable Integer id_usuario) {
        return alumnoRepository.findById_usuario(id_usuario)
                .map(user -> {
                    Response response = new SuccessResponse(user);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Response response = new FailResponse("Alumno no encontrado", "");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                });
    }
    */

    @PostMapping
    public ResponseEntity<Response> createAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.ok(new SuccessResponse(alumnoRepository.save(alumno)));
    }
}
