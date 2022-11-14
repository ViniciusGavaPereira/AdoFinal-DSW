package ado.demo.Repository;

import ado.demo.Entity.Movies;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface MovieRepository extends JpaRepository<Movies,Long> {
    
}
