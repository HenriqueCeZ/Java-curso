package org.aguzman.com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.aguzman.com.jdbc.entity.Producto;
import org.aguzman.com.jdbc.repositorio.ProductoRepositoryImp;
import org.aguzman.com.jdbc.repositorio.Repository;
import org.aguzman.com.jdbc.util.ConnectionDB;

public class ExemploJDBC {

	public static void main(String[] args) {


		try (Connection conn = ConnectionDB.getInstance()){
				
				Repository<Producto> repositorio = new ProductoRepositoryImp();
				System.out.println("======== listar =========");
				repositorio.listar().forEach(System.out::println);	
				
				System.out.println("======== Busca por id =========");
				System.out.println(repositorio.porId(2L));
				
				System.out.println("======== Inserir novo produto =========");
				Producto producto = new Producto();
				producto.setNome("Teclado mecânico");
				producto.setPreco(500);
				producto.setFicha_registro(new Date());
				repositorio.guardar(producto);
				System.out.println("Produto guardado com sucesso");
			}

			

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
