package backPortafolio.portafolio.mensajes.application;

import java.util.List;

import backPortafolio.portafolio.mensajes.domain.Mensaje;

public interface Imensaje {
Mensaje enviarMensaje(Mensaje mensaje);
List<Mensaje> mostrarMensajes();
}
