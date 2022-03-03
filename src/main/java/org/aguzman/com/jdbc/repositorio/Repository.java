package org.aguzman.com.jdbc.repositorio;

import java.util.List;

public interface Repository<T> {
	
	List<T> listar();
	
	T porId(Long id);
	
	void guardar(T t);
	
	void eliminar(Long id);
}
