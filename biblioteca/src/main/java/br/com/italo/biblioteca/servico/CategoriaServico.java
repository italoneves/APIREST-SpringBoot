package br.com.italo.biblioteca.servico;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.repositorio.CategoriaRepositorio;
import br.com.italo.biblioteca.servico.exception.ObjetoExistente;
import br.com.italo.biblioteca.servico.exception.ObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        /*1 - Só cria se o ID não existir no BD.
          2 - Posso implementar jogando ID para null e gerar outro no BD
          3 - Implementar em caso de nome de categoria iguais e etc
         */
    }

    public Categoria atualizarCategoria(Integer id, Categoria categoria){

        Optional<Categoria> c = Optional.ofNullable(categoriaRepositorio.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontrado("Categoria não encontrada")));
       //Pego o objeto caso não tenha exception e atualizo
        Categoria c1 = c.get();
        c1.setNome(categoria.getNome());
        c1.setDescricao(categoria.getDescricao());
        categoriaRepositorio.save(c1);
        return c1;

    }

    public void deletarCategoria(Integer id){

        Optional<Categoria> c = Optional.ofNullable(categoriaRepositorio.findById(id))
                .orElseThrow(()-> new ObjetoNaoEncontrado("Essa categoria não existe"));
        //Caso existe deleto categoria.
        categoriaRepositorio.deleteById(id);


    }
}
