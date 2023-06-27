package mx.edu.uteq.idgs06.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table (name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @NotEmpty
    private String usuario;
    @NotEmpty
    //@Size(min=3, max=50)
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "usuario")
    private List<Telefonos> telefonos;
}
