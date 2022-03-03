package org.aguzman.com.jdbc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aguzman.com.jdbc.entity.Producto;
import org.aguzman.com.jdbc.util.ConnectionDB;

public class ProductoRepositoryImp implements Repository<Producto> {

	private Connection getConnection() throws SQLException {

		return ConnectionDB.getInstance();
	}

	@Override
	public List<Producto> listar() {

		List<Producto> productos = new ArrayList<>();

		try (Statement stmt = getConnection().createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {

			while (rs.next()) {
				Producto p = criarProducto(rs);
				productos.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	@Override
	public Producto porId(Long id) {
		Producto producto = null;
		try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM productos WHERE id = ?")) {

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				producto = criarProducto(rs);

			}
			

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return producto;
	}

	@Override
	public void guardar(Producto producto) {
		
		String sql;
		if (producto.getId() != null && producto.getId() > 0) {
			sql = "UPDATE productos SET nombre=? , precio=? WHERE id=?";
		} else {
			sql = "INSERT INTO productos(nome, preco, ficha_registro) VALUES(?,?,?)";
		}
		
		try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
			stmt.setString(1, producto.getNome());
			stmt.setLong(2, producto.getPreco());
			
			//stmt.setDate(3, new Date(producto.getFichaRegistro().getTime()));
			stmt.executeUpdate();
			
			if (producto.getId() != null && producto.getId() > 0) {
				stmt.setLong(3, producto.getId());
			} else {
				stmt.setDate(3,  (java.sql.Date) new Date(producto.getFicha_registro().getTime()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(Long id) {
		try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM productos WHERE id=?")) {
			stmt.setLong(1,id);
			stmt.executeUpdate();
		} catch(SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	private Producto criarProducto(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		p.setId(rs.getLong("id"));
		p.setNome(rs.getString("nome"));
		p.setPreco(rs.getInt("preco"));
		p.setFicha_registro(rs.getDate("ficha_registro"));
		
		return p;
	}

}
