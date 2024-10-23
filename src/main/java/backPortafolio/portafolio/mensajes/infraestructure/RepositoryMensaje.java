package backPortafolio.portafolio.mensajes.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backPortafolio.portafolio.mensajes.domain.Mensaje;

@Repository
public interface RepositoryMensaje extends JpaRepository<Mensaje,Long>{

}
