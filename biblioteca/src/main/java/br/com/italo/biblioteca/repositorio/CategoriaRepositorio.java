package br.com.italo.biblioteca.repositorio;

import br.com.italo.biblioteca.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {


}
