package br.usjt.arqdsis.exemplorest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.usjt.arqdsis.exemplorest.model.Usuario;
import br.usjt.arqdsis.exemplorest.service.UsuarioService;

/**
 * Created by elcio on 04/03/16.
 */
@Path("/usuario")
public class UsuarioRest {

    @GET
    @Path("/todos")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAllUsuarios()
            throws  InstantiationException, IllegalAccessException, ClassNotFoundException {

        UsuarioService usuarioService = new UsuarioService();

        return Response.ok(usuarioService.getAllUsuarios()).build();
    }
   
    
    @GET
    @Path("/{nome}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getUsuarioById(@PathParam("nome") String nome)
            throws  InstantiationException, IllegalAccessException, ClassNotFoundException {

        UsuarioService usuarioService = new UsuarioService();

        return Response.ok(usuarioService.getUsuarioByName(nome)).build();
    }
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUsuario(Usuario usuario)
			throws  InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		listaUsuarios.add(usuario);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.createOrUpdateAllUsuarios(listaUsuarios);
		
		return Response.status(Status.OK).build();
	}
    
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createUsuario(@FormParam("id") long id, @FormParam("nome") String nome,@FormParam("idade") int idade,@FormParam("email") String email, @FormParam("senha") String senha)
			throws  InstantiationException, IllegalAccessException, ClassNotFoundException {

		Usuario usuario = new Usuario(id,nome,idade,email,senha);
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		listaUsuarios.add(usuario);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.createOrUpdateAllUsuarios(listaUsuarios);
		
		return Response.status(Status.OK).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response saveUsuario(@FormParam("id") long id, @FormParam("nome") String nome,@FormParam("idade") int idade,@FormParam("email") String email, @FormParam("senha") String senha)
			throws  InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Usuario usuario = new Usuario(id,nome,idade,email,senha);
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		listaUsuarios.add(usuario);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.createOrUpdateAllUsuarios(listaUsuarios);
		
		return Response.status(Status.OK).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveUsuario(Usuario usuario)
			throws  InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		listaUsuarios.add(usuario);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.createOrUpdateAllUsuarios(listaUsuarios);
		
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("/deletar/{id}")
	public Response deleteUsuario(@PathParam("id") long id)
			throws  InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.deleteUsuario(id);
		
		return Response.status(Status.OK).build();
	}
	
}

