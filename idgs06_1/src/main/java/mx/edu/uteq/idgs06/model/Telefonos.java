package mx.edu.uteq.idgs06.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "telefonos")
public class Telefonos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTelefono;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;
}
