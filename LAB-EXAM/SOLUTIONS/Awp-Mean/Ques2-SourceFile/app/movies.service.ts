import { Injectable } from '@angular/core';
import { Movie } from './Movie';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  movies:Movie[];
  
    constructor() { 
      this.movies=[new Movie(1,'Thor','John'),new Movie(2,'Joker','Kyle')];
    }
   
    addMovie(movie:Movie){
      this.movies.push(movie);
    }
}
