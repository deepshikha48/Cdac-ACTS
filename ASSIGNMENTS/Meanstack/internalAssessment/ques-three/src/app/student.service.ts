import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  baseUrl:string = "http://localhost:8080/students/";

  constructor(private http:HttpClient) { }

  getStudents():Observable<Student[]>{
    return this.http.get<Student[]>(this.baseUrl);
  }

  fetchStudentById(id:number):Observable<Student>{
    return this.http.get<Student>(this.baseUrl+"id/"+id);
  }

  addNewStudent(student:Student){
    return this.http.post<Student>(this.baseUrl+"store/",student);
  }

}
