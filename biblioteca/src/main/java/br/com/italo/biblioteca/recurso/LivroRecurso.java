package br.com.italo.biblioteca.recurso;

import br.com.italo.biblioteca.dominio.Livro;
import br.com.italo.biblioteca.servico.LivroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livro")
public class LivroRecurso {

    @Autowired
    private LivroServico livroServico;

    @GetMapping(value = "{id}")
    public ResponseEntity<Livro> buscarId(@PathVariable Integer id ){
        Livro l = livroServico.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(l);
    }
    @PostMapping
    public ResponseEntity<Livro> adicionarLivro(@RequestParam(value = "categoria",defaultValue = "0")Integer cat_id,
                                                @RequestBody Livro livro){
        Livro l = livroServico.adicionarLivro(livro,cat_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(l);
    }

}
