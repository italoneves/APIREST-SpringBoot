package br.com.italo.biblioteca.recurso;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.dto.CategoriaDTO;
import br.com.italo.biblioteca.servico.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //Criação de Endpoint
@RequestMapping("/categoria")
public class CategoriaRecurso {

//Preciso melhorar a conversão para DTO.
    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarId(@PathVariable Integer id){

            return ResponseEntity.ok().body(categoriaServico.buscarId(id));

    }
    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria){

        Categoria categoria1 = categoriaServico.adicionarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria1);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){

        Categoria categoria1 = categoriaServico.atualizarCategoria(id, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria1);

    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id){
        categoriaServico.deletarCategoria(id);
        return ResponseEntity.ok().build();


    }


}
