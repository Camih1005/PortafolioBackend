package backPortafolio.portafolio.mensajes.infraestructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backPortafolio.portafolio.mensajes.domain.Mensaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api")
public class ControllerMensaje {

    @Autowired
    private Servicio servicio;

    @PostMapping("/mensaje")
    public Mensaje enviarMensaje(@RequestBody Mensaje mensaje) {
       
        
        return servicio.enviarMensaje(mensaje);
    }



    @GetMapping("/mensaje")
    public List<Mensaje> obtenerMensajes() {
        return servicio.mostrarMensajes();
    }
    

}
