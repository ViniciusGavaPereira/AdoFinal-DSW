package ado.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Movies{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String genero;
    private Long anoLancamento;
  
  

    
    public Movies() {
    }

    public Movies(String titulo, String genero, Long anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Long anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

   




    
}
