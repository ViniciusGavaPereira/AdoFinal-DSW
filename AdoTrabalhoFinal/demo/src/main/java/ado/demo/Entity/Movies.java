package ado.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Movies{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String genero;
    private String anoLancamento;


    
}
