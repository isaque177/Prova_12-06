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

import Model.bibliotecario_model;
import Service.bibliotecario_service;

@RestController
@RequestMapping("/api/bibliotecario")
@CrossOrigin(origins = "*")
public class bibliotecario_controller {

    @Autowired
    private bibliotecario_service bibliotecarioService;

    @PostMapping
    public bibliotecario_model adicionar(@RequestBody bibliotecario_model bibliotecario) {
        return bibliotecarioService.salvar(bibliotecario);
    }

    @GetMapping
    public List<bibliotecario_model> listar() {
        return bibliotecarioService.listar();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        bibliotecarioService.remover(id);
    }

    @PutMapping("/{id}")
    public bibliotecario_model atualizar(@PathVariable Long id, @RequestBody bibliotecario_model bibliotecario) {
        return bibliotecarioService.atualizar(id, bibliotecario);
    }
}