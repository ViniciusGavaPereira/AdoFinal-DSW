package ado.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Movies{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull(message = "O filme precisa de um titulo")
    private String titulo;
    private String genero;

    @Size(min = 1895, max = 2022, message = " O ano de lançamento precisa ser entre 1895 até o ano atual")
    private Long anoLancamento;

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

    public Movies() {
    }

    public Movies(long id, @NotNull(message = "O filme precisa de um titulo") String titulo, String genero,
            @Size(min = 1895, max = 2022, message = " O ano de lançamento precisa ser entre 1895 até o ano atual") Long anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
  
  


    
}
