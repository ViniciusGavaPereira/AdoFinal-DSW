package ado.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ado.demo.Entity.Movies;


import ado.demo.Service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(value="/createMovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies salvar(@RequestBody Movies movies){
        return movieService.save(movies);
    }


    @GetMapping(value="/findAll")
    public List<Movies> listaFilmes(){
        return movieService.listaFilme();

    }

    @GetMapping("/{id}")
    public Movies buscarPorId(@PathVariable Long id){
        return movieService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFilme(@PathVariable Long id){
        movieService.buscarPorId(id).map(movies -> {movieService.removePorID(movies.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não existe"));
    }

}
