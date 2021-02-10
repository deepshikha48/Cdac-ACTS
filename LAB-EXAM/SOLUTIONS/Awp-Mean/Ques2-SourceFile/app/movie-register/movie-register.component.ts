import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MoviesService } from '../movies.service';

@Component({
  selector: 'app-movie-register',
  templateUrl: './movie-register.component.html',
  styleUrls: ['./movie-register.component.css']
})
export class MovieRegisterComponent implements OnInit {

  constructor(private service:MoviesService) { }

  ngOnInit(): void {
  }

  registerMovie(movieForm:NgForm){
    this.service.addMovie(movieForm.value);
  }

}
