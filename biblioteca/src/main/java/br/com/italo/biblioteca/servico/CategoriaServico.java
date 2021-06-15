package br.com.italo.biblioteca.servico;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.dto.CategoriaDTO;
import br.com.italo.biblioteca.repositorio.CategoriaRepositorio;
import br.com.italo.biblioteca.servico.exception.ObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public Categoria buscarId(Integer id){

          Optional<Categoria> c = Optional.ofNullable(categoriaRepositorio.findById(id).orElseThrow(()
                  -> new ObjetoNaoEncontrado("Id não encontrado")));

          Categoria c1 = c.get();
          return c1;
    }
    public Categoria adicionarCategoria(Categoria categoria){

        Optional<Categoria> c = categoriaRepositorio.findById(categoria.getId());
        if (!c.isPresent()){
            categoriaRepositorio.save(categoria);
        }
        return categoria;
    }


    public Categoria atualizarCategoria(Integer id, Categoria categoria){

        Optional<Categoria> c = Optional.ofNullable
                (categoriaRepositorio.findById(id)).orElseThrow(() -> new ObjetoNaoEncontrado());
       //Pego o objeto caso não tenha exception e atualizo
        Categoria c1 = c.get();
        c1.setNome(c1.getNome());
        c1.setDescricao(categoria.getDescricao());


        return null;

    }
}
