package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Model.livro_model;
import Repository.livros_repository;

@Service

public class livros_service {
    

    @Autowired
    private livros_repository livros_repository;

    public List <livro_model> listar (){
       return livros_repository.findAll();
    }

    public livro_model salvar(livro_model livro_model) {
        return livros_repository.save(livro_model);
    }



    public void remover(Long id) {
        livros_repository.deleteById(id);
    }

    public livro_model atualizar(Long id, livro_model livro_model) {
        livro_model.setId(id);
        return livros_repository.save(livro_model);
    }

    

}
