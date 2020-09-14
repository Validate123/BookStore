package com.example.demo.service;

import com.example.demo.domain.Anime;
import com.example.demo.utility.Utility;
import com.example.demo.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnimeService {

    private final Utility utility;
    private final AnimeRepository animeRepository;

    public Anime findById(int id) {

        return utility.findAnimeOrThrowNotFound(id, animeRepository);
    }

    public List<Anime> findByName(String name) {

        return animeRepository.findByName(name);
    }

    public List<Anime> listAll() {

        return animeRepository.findAll();
    }

    public Anime save(Anime anime) {

        return animeRepository.save(anime);
    }

    public void delete(int id) {

        animeRepository.delete(utility.findAnimeOrThrowNotFound(id,animeRepository));
    }

    public void update(Anime anime) {

        animeRepository.save(anime);
    }
}
