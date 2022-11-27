package ado.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @GetMapping("/findAll")
    public List listaFilmes(ModelAndView model){

        List<Movies> listaFilmes = movieService.listaFilme();

        model.addObject("list", listaFilmes);

        return listaFilmes;
    }


    
    @PostMapping(value="/createMovie")
    public void salvar(Movies movies){

        movieService.save(movies);


    }

/*
 *   
    @PostMapping(value="/createMovie")
    public ModelAndView salvar(Movies movies){

        movieService.save(movies);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list.html");
        return modelAndView;

    }

 * 
 * 
 */


   



    @GetMapping("/gerarTela2")
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("/list");
        mav.addObject("listaFilmes", movieService.listaFilme());


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
        System.out.println(mav);

       // mav.setViewName("mostrarFilmes");

        return mav;
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




  


   

}
