package mx.edu.uteq.idgs06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.uteq.idgs06.dao.IPersonaDao;
import mx.edu.uteq.idgs06.model.Usuario;

@Controller
public class ControladorInicio {
	@Autowired
    IPersonaDao personaDao;
    
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("texto", "Este es un ejempo de thymeleaf ");
        return "index";
    }

    @GetMapping("/usuarios")
    public String otroMetodo(Model model) {
        List<Usuario> datos = personaDao.findAll();
        model.addAttribute("datos", datos);
        return "usuarios";
    }

    /*
    @GetMapping("/agregar-usuarios")
    public String paginaAddUsuarios(Model model) {
        model.addAttribute("operacion", "Agregar Usuarios");
        return "usuarios/frmUsuario";
    }
    
    @GetMapping("/guardar-usuarios")
    public String guardarUsuarios(Model model, Usuario usuario) {
        personaDao.save(usuario);
        model.addAttribute("dato", usuario);
        return "usuarios/usuarios";
    }
    @GetMapping("/editar-usuarios")
    public String paginaEditarUsuarios(Model model, Usuario usuario) {
        usuario = personaDao.findById(usuario.getIdUsuario());
        
        model.addAttribute("operacion", "Editar Usuario");
        model.addAttribute("dato", usuario);
        return "usuarios/frmUsuario";
    }
    */

}
