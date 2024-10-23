package backPortafolio.portafolio.user.infraestructure;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backPortafolio.portafolio.user.domain.User;

@RestController
@RequestMapping("/api/auth")
public class AuthUserController {

     @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        Optional<User> user = userRepository.findByUser(loginRequest.getUser());
        
        if (user.isPresent() && user.get().getContraseña().equals(loginRequest.getContraseña())) {
          
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
