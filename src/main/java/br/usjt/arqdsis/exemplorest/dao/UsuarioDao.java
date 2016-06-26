package br.usjt.arqdsis.exemplorest.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.usjt.arqdsis.exemplorest.model.Usuario;
import br.usjt.arqdsis.exemplorest.util.HibernateUtil;

/**
 * Created by elcio on 04/03/16.
 */
public class UsuarioDao {

	private Session session;
	private Transaction tx;

	public UsuarioDao() {

		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();

	}

	public void createUsuarios(List<Usuario> usuarios) {

		try {

			for (Usuario n : usuarios) {
				session.save(n);
				tx.commit();
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void createOrUpdateUsuarios(List<Usuario> usuarios) {

		String sql = "";
		SQLQuery query = null;
		Usuario usuario;

		try {
			for (Usuario n : usuarios) {
				sql = "SELECT * FROM usuario WHERE id = :id";
				query = session.createSQLQuery(sql);
				query.addEntity(Usuario.class);
				query.setParameter("id", n.getId());
				usuario = (Usuario) query.uniqueResult();
				if (usuario != null) {
					n.setId(usuario.getId());
					session.flush();
					session.clear();
					session.update(n);
				} else {
					n.setId(0L);
					session.save(n);
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	public Usuario getUsuarioByName(String name) {

		String sql = "";
		SQLQuery query = null;
		Usuario usuario = null;

		try {
			sql = "SELECT * FROM usuario WHERE nome = :nome";
			query = session.createSQLQuery(sql);
			query.addEntity(Usuario.class);
			query.setParameter("nome", name);
			usuario = (Usuario) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public Usuario getUsuarioById(long id) {

		String sql = "";
		SQLQuery query = null;
		Usuario usuario = null;

		try {
			sql = "SELECT * FROM usuario WHERE id = :id";
			query = session.createSQLQuery(sql);
			query.addEntity(Usuario.class);
			query.setParameter("id", id);
			usuario = (Usuario) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getAllUsuarios() {

		String sql = "";
		SQLQuery query = null;
		List<Usuario> usuarios = null;

		try {
			sql = "select * FROM usuario";
			query = session.createSQLQuery(sql);
			query.addEntity(Usuario.class);
			usuarios = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void deleteUsuario(long id) {

		Usuario usuario = getUsuarioById(id);

		if (usuario != null) {
			try {
				session.delete(usuario);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		}

	}
}