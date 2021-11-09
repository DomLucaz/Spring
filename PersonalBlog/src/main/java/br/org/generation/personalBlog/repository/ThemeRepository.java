package br.org.generation.personalBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.personalBlog.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long>{
    
    public List <Theme> findAllByDescricaoContainingIgnoreCase (String descricao);

}