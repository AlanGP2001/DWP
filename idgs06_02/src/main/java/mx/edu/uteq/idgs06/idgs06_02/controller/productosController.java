/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package mx.edu.uteq.idgs06.idgs06_02.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.edu.uteq.idgs06.idgs06_02.model.entity.Producto;
import mx.edu.uteq.idgs06.idgs06_02.model.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ari Cruz Ortiz
 */
@Controller
@Slf4j
public class productosController {
    @Autowired
        private ProductosRepository repo;
    
    
   @RequestMapping("/productos")
    public String categorias(Model model) {
        return "/productos/productos";
    }
    
    //Vamos a traer todos los productos registrados en el sistema
    @GetMapping(value = "/api/productos", produces = "application/json")
    public @ResponseBody List obtenerCategorias() {
        //obtener datos
        List lista = repo.findAll();
        log.info(String.valueOf(lista.size()));
        return lista;
    }
    
    @PostMapping(value = "/api/productos", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> guardar(@Valid @RequestBody Producto categoria, Errors error) throws Exception{
        log.info("cat:"+categoria.toString());
        if (error.hasErrors()){
            throw new Exception(error.toString());
        }
        return new ResponseEntity<>(repo.save(categoria), HttpStatus.CREATED);
    }
}
