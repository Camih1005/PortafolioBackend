package backPortafolio.portafolio.mensajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist; // Importar para establecer la fecha automáticamente
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    @Column(columnDefinition = "text")
    private String mensaje;

    private LocalDateTime fechaupdate;
    
    private boolean visto; 

    @PrePersist
    protected void onCreate() {
        fechaupdate = LocalDateTime.now(); 
        visto = false; 
    }
}

