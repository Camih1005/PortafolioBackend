package backPortafolio.portafolio.mensajes.infraestructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backPortafolio.portafolio.mensajes.application.Imensaje;
import backPortafolio.portafolio.mensajes.domain.Mensaje;


@Service
public class Servicio implements Imensaje {

    @Autowired
    private RepositoryMensaje mensajeRepository;

    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
    
        return mensajeRepository.save(mensaje);
    }

    @Override
    public List<Mensaje> mostrarMensajes() {

        return mensajeRepository.findAll();
    }
}
