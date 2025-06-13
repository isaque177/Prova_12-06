package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.bibliotecario_model;
import Repository.bibliotecario_repository;

@Service

public class bibliotecario_service {
    
    @Autowired
    private bibliotecario_repository bibliotecario_repository;

    public List <bibliotecario_model> listar (){
       return bibliotecario_repository.findAll();
    }

    public bibliotecario_model salvar(bibliotecario_model bibliotecario_model) {
        return bibliotecario_repository.save(bibliotecario_model);
    }



    public void remover(Long id) {
        bibliotecario_repository.deleteById(id);
    }

    public bibliotecario_model atualizar(Long id, bibliotecario_model bibliotecario_model) {
        bibliotecario_model.setId(id);
        return bibliotecario_repository.save(bibliotecario_model);
    }
}

