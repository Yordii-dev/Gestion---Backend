package Claridad.Controller;

import Claridad.Model.Alumno;
import Claridad.Model.Usuario;
import Claridad.Repository.AuthRepository;
import Claridad.Response.FailResponse;
import Claridad.Response.Response;
import Claridad.Response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody Usuario usuario) {
        return authRepository.findByCorreoAndContrasena(usuario.getCorreo(), usuario.getContrasena())
                .map(user -> {
                    Response response = new SuccessResponse(user);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Response response = new FailResponse("Usuario o contraseña incorrectos", "Verifica tus credenciales y vuelve a intentarlo");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                });
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> signin(@RequestBody Usuario usuario) {

       return ResponseEntity.ok(new SuccessResponse(authRepository.save(usuario)));
    }
}
