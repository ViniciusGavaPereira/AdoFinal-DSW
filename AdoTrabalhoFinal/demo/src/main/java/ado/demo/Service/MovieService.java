package ado.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ado.demo.Repository.MovieRepository;
import ado.demo.Entity.Movies;


@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    
    public Movies save(Movies movie){
        return movieRepository.save(movie);
    }

    public List<Movies> listaFilme(){
        return movieRepository.findAll();
    }

    public void removePorID(Long id){
        movieRepository.deleteById(id);
    }

    public Optional<Movies> buscarPorId(Long id){
        return movieRepository.findById(id);

    }
}
