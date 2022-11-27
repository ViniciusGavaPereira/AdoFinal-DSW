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



    @GetMapping("/telaInicial")
    public ModelAndView criarTelaInicial(){
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("listaFilmes", movieService.listaFilme());

        return mav;
    }

    @GetMapping("/gerarTela")
    public ModelAndView criarTela(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filme.html");
        return modelAndView;
    }

    
    @PostMapping(value="/createMovie")
    public ModelAndView salvar(Movies movies){

        movieService.save(movies);

        ModelAndView mav = new ModelAndView("/list");
        mav.addObject("listaFilmes", movieService.listaFilme());

        return mav;
    }

    @GetMapping("/gerarTela2")
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("/list");
        mav.addObject("listaFilmes", movieService.listaFilme());

        System.out.println(mav);

       // mav.setViewName("mostrarFilmes");

        return mav;
    }
 




  


   

}
