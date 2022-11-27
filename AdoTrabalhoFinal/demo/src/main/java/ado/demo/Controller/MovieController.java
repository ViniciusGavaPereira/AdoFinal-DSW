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

        movieService.save(movies);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list.html");
        return modelAndView;

    }

    @GetMapping("/lista")
    public ModelAndView criarLista(){
        ModelAndView modelAndView = new ModelAndView("lista");
        List<Movies> listaFilmes = movieService.listaFilme();
        modelAndView.addObject("lista", listaFilmes);

        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println("########################################################################");
        System.out.println(listaFilmes);



        modelAndView.setViewName("list.html");

        return modelAndView;
    }





   /* FUNCIONA 
   
   @PostMapping(value="/createMovie")
    public ModelAndView salvar(Movies movies){


        movieService.save(movies);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list.html");
      
        return modelAndView;
    }
 */




    @GetMapping("/findAll")
    public String listaFilmes(ModelAndView model){

        List<Movies> listaFilmes = movieService.listaFilme();

        model.addObject("list", listaFilmes);

        return "list.html";
    }


   

}
