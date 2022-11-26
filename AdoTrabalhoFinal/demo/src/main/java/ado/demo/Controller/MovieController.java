package ado.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import ado.demo.Entity.Movies;


import ado.demo.Service.MovieService;

@RestController
public class MovieController {


    @Autowired
    private MovieService movieService;



    @GetMapping("/gerarTela")
    public ModelAndView criarTela(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filme.html");
        return modelAndView;
    }

    @PostMapping(value="/createMovie")
    public ModelAndView salvar(Movies movies){

        System.out.println(" #####################################################################################################################:");    

     //   System.out.println("Titulo do filme salvos: " + movies);    

        System.out.println("Titulo do filme salvos: " + movies.getTitulo());    
        System.out.println("Gênero do filme salvos: " + movies.getGenero());    
        System.out.println("Ano de lançamento do filme salvos: " + movies.getAnoLancamento());    

        movieService.save(movies);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }


    @GetMapping(value="/findAll")
    public List<Movies> listaFilmes(){
        return movieService.listaFilme();

    }


   

}
