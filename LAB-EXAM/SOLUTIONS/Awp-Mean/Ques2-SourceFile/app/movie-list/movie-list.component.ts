import { Component, OnInit } from '@angular/core';
import { Movie } from '../Movie';
import { MoviesService } from '../movies.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies:Movie[]=[];
  constructor(private service:MoviesService) { }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies()
  {
    this. movies=this.service.movies;
  }

}
