package com.example.demo.repository;

import com.example.demo.Domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

    List<Anime> findByName(String name);
}
