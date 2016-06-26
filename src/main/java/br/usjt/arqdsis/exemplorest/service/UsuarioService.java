package br.usjt.arqdsis.exemplorest.service;

import java.util.List;

import br.usjt.arqdsis.exemplorest.dao.UsuarioDao;
import br.usjt.arqdsis.exemplorest.model.Usuario;

/**
 * Created by elcio on 04/03/16.
 */
public class UsuarioService {

    private UsuarioDao usuarioDao;

    public UsuarioService(){
        usuarioDao = new UsuarioDao();
    }

    public void createOrUpdateAllUsuarios(List<Usuario> usuarios){
        usuarioDao.createOrUpdateUsuarios(usuarios);
    }

    public Usuario getUsuarioByName(String name){
        return usuarioDao.getUsuarioByName(name);
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioDao.getAllUsuarios();
    }
    
    public void deleteUsuario(long id){
    		usuarioDao.deleteUsuario(id);
    }

}
