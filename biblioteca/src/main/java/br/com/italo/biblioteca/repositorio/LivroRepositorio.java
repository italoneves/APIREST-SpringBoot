package br.com.italo.biblioteca.repositorio;

import br.com.italo.biblioteca.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro, Integer> {
}
