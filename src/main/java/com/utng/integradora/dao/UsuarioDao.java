package com.utng.integradora.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.utng.integradora.form.Usuario;

public class UsuarioDao {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDao.class);
	private JdbcTemplate jt;

	public UsuarioDao(DataSource ds) {
		jt = new JdbcTemplate(ds);
	}
	
	public Usuario login(String correo, String password) {
		logger.info("Método login DAO correo " + correo + " Contraseña " + password);
		
		String sql = "SELECT * FROM usuario WHERE correo = ? AND password = ?;";

		try {
			return jt.queryForObject(sql, new Object[] { correo, password },
					new BeanPropertyRowMapper<Usuario>(Usuario.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Usuario> getUsuarios() {
		logger.info("Método getUsuarios Modelo " + this);
		List<Usuario> list = new ArrayList<Usuario>();
		
		list = jt.query("select correo, password from usuario", new RowMapper() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                return usuario;
            }
        });
		return list;
	}

	@Override
	public String toString() {
		return "UsuarioDao [JDBCTemplate=" + this.jt + "]";
	}

	
	
}
