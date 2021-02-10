import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MoviesService } from './movies.service';
import { FormsModule } from '@angular/forms';
import { MovieRegisterComponent } from './movie-register/movie-register.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    MovieRegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [MoviesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
