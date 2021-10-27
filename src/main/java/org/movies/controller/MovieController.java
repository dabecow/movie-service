package org.movies.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.movies.dto.ActorDto;
import org.movies.dto.GenreDto;
import org.movies.dto.MovieDto;
import org.movies.model.Movie;
import org.movies.response.PageableResponse;
import org.movies.service.IMovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    @PostMapping("/createMovie")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.createMovie(movieDto), HttpStatus.OK);
    }

    @DeleteMapping("/removeById")
    public ResponseEntity<?> removeMovieById(Long id){
        movieService.removeMovieById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<PageableResponse<MovieDto>> findAll(Pageable pageable){
        return new ResponseEntity<>(movieService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/findAllByGenre")
    public ResponseEntity<PageableResponse<MovieDto>> findAllByGenre(@RequestBody GenreDto genreDto, Pageable pageable){
        return new ResponseEntity<>(movieService.findAllByGenre(genreDto, pageable), HttpStatus.OK);
    }

    @GetMapping("/findAllByActor")
    public ResponseEntity<PageableResponse<MovieDto>> findAllByActor(@RequestBody ActorDto actorDto, Pageable pageable){
        return new ResponseEntity<>(movieService.findAllByActor(actorDto, pageable), HttpStatus.OK);
    }
}
