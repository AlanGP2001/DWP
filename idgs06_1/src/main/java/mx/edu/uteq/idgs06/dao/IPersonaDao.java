package mx.edu.uteq.idgs06.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs06.model.Usuario;

public interface IPersonaDao extends JpaRepository<Usuario, Long> {

}
