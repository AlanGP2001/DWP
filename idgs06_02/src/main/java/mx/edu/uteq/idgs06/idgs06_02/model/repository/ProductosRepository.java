/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package mx.edu.uteq.idgs06.idgs06_02.model.repository;


import mx.edu.uteq.idgs06.idgs06_02.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alberto
 */
public interface ProductosRepository extends JpaRepository<Producto, Integer> {
    
}
