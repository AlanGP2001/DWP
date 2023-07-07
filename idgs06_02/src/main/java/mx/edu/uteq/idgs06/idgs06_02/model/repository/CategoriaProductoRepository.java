/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package mx.edu.uteq.idgs06.idgs06_02.model.repository;

import mx.edu.uteq.idgs06.idgs06_02.model.entity.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alberto
 */
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {
    
}
