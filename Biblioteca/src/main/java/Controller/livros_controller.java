package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Model.livro_model;
import Service.livros_service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping ("/livros")
@CrossOrigin(
    origins = "*"
)

public class livros_controller {

    @Autowired
    private livros_service livros_service;

    @PostMapping
    public livro_model salvar (@RequestBody livro_model livro_model){
        return livros_service.salvar(livro_model);
    }

    @GetMapping
    public List <livro_model> listar(){
        return livros_service.listar();
    }

     @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        livros_service.remover(id);
    }

     @PutMapping("/{id}")
    public livro_model atualizar(@PathVariable Long id, @RequestBody livro_model livro_model) {
        return livros_service.atualizar(id, livro_model);
    }
    
}
