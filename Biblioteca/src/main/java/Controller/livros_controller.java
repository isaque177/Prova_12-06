package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.livro_model;
import Service.livros_service;

@RestController
@RequestMapping("/api/livros") // Corrigido: estava "/livros"
@CrossOrigin(origins = "*")
public class livros_controller {

    @Autowired
    private livros_service livrosService;

    @PostMapping
    public livro_model salvar(@RequestBody livro_model livro) {
        return livrosService.salvar(livro);
    }

    @GetMapping
    public List<livro_model> listar() {
        return livrosService.listar();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        livrosService.remover(id);
    }

    @PutMapping("/{id}")
    public livro_model atualizar(@PathVariable Long id, @RequestBody livro_model livro) {
        return livrosService.atualizar(id, livro);
    }
}