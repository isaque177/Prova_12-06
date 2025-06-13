package Repository;
import Model.bibliotecario_model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bibliotecario_repository extends JpaRepository <bibliotecario_model,Long> {
    
}
