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
@RequestMapping("/bibliotecario")
@CrossOrigin(
    origins = "*"
)

class bibliotecario_controller {

    @Autowired
    private bibliotecario_service biliotecario_service;



    @PostMapping
    public bibliotecario_model adicionar(@RequestBody bibliotecario_model bibliotecario_model) {
        return biliotecario_service.salvar(bibliotecario_model);
    }

    @GetMapping
    public List<bibliotecario_model> listar() {
        return biliotecario_service.listar();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        biliotecario_service.remover(id);
    }

    @PutMapping("/{id}")
    public bibliotecario_model atualizar(@PathVariable Long id, @RequestBody bibliotecario_model bibliotecario_model) {
        return biliotecario_service.atualizar(id, bibliotecario_model);
    }
    
}