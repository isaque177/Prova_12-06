package com.example.Atividade_API_3.controller;

import com.example.Atividade_API_3.model.ImagemModel;
import com.example.Atividade_API_3.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagens")
@CrossOrigin(
    origins = "http://127.0.0.1:5500",
    allowedHeaders = "*"
)

public class ImagemController {

    @Autowired
    private ImagemService service;

    @PostMapping
    public ImagemModel adicionar(@RequestBody ImagemModel imagem) {
        return service.salvar(imagem);
    }

    @GetMapping
    public List<ImagemModel> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    @PutMapping("/{id}")
    public ImagemModel atualizar(@PathVariable Long id, @RequestBody ImagemModel imagem) {
        return service.atualizar(id, imagem);
    }
}