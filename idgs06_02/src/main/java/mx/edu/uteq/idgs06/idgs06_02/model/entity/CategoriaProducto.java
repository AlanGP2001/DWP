
package mx.edu.uteq.idgs06.idgs06_02.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author alberto
 */

@Entity
@Data
public class CategoriaProducto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true)
    @NotEmpty
    private String categoriaProd;
    
    private boolean activo;

}
