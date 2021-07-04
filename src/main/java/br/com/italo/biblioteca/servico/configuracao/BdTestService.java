package br.com.italo.biblioteca.servico.configuracao;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.dominio.Livro;
import br.com.italo.biblioteca.repositorio.CategoriaRepositorio;
import br.com.italo.biblioteca.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class BdTestService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private LivroRepositorio livroRepositorio;

    public void popularDados(){

        Categoria c1 = new Categoria(null, "Tecnologia", "Livros da área de tecnologia");
        Categoria c2 = new Categoria(null, "Financeiro", "Livros sobre finanças");
        Livro l1 = new Livro(null, "Angular 10", "fulano 1 ", "Essencial na vida de um dev",
                LocalDate.of(2021,06,22),c1);
        Livro l2 = new Livro(null, "Pai Rico, Pai Pobre", "fulano 2", "Para a vida",
                LocalDate.of(2021,06,22),c2);
        Livro l3 = new Livro(null, "JAVA", "Paul Deitel", "Como ser feliz...",
                LocalDate.of(2021,06,22),c1);

        categoriaRepositorio.saveAll(Arrays.asList(c1,c2));
        livroRepositorio.saveAll(Arrays.asList(l1,l2,l3));

    }


}
