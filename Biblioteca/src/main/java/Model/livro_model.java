package Model;

import javax.xml.crypto.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "Livros")

public class livro_model {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
   @JoinColumn(name = "bibliotecario_id")private bibliotecario_model bibliotecario_model;
   
   private String titulo;
   private String autor;
   private String genero;
   private String staatus;
   private Data data_cadastro;

   
}

