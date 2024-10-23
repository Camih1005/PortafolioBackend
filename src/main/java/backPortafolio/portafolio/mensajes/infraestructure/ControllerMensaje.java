package backPortafolio.portafolio.mensajes.infraestructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backPortafolio.portafolio.mensajes.domain.Mensaje;
import backPortafolio.portafolio.mensajes.infraestructure.RepositoryMensaje;
import backPortafolio.portafolio.mensajes.infraestructure.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class ControllerMensaje {

    @Autowired
    private Servicio servicio;

    @Autowired
    private RepositoryMensaje repositoryMensaje;

    @PostMapping("/mensaje")
    public Mensaje enviarMensaje(@RequestBody Mensaje mensaje) {
        mensaje.setVisto(false);
        return servicio.enviarMensaje(mensaje);
    }
    

    @GetMapping("/mensaje")
    public List<Mensaje> obtenerMensajes() {
        return servicio.mostrarMensajes();
    }

    @PutMapping("/mensaje/{id}/visto")
    public ResponseEntity<Mensaje> marcarComoVisto(@PathVariable Long id) {
        Optional<Mensaje> mensajeOptional = repositoryMensaje.findById(id);

        if (mensajeOptional.isPresent()) {
            Mensaje mensaje = mensajeOptional.get();
            mensaje.setVisto(true); 
            repositoryMensaje.save(mensaje); 
            return ResponseEntity.ok(mensaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
