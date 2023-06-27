package mx.edu.uteq.idgs06.service;

import java.util.List;

import mx.edu.uteq.idgs06.model.Usuario;

public interface IUsuarioService {
	public List<Usuario> finAll();
    public Usuario findById(int id);
    public Usuario save(Usuario usuario);
    public void deleteById(int id);
    public void delete(Usuario usuario);
}
