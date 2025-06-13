package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.livro_model;

@Repository
public interface livros_repository extends JpaRepository < livro_model,Long>{


    
}
    

