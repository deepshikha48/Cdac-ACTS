import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../model/feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  baseUrl: string = "http://localhost:8080/feedback";

  constructor(private http: HttpClient) { }

  addFeedback(feedback: Feedback):Observable<Feedback> {
    let id=sessionStorage.getItem("validUserId");
    return this.http.post<Feedback>(this.baseUrl+ "/" +id, feedback);
  }

  getAllFeedback():Observable<Feedback[]>{
    return this.http.get<Feedback[]>(this.baseUrl+ "/list");
  }
}
