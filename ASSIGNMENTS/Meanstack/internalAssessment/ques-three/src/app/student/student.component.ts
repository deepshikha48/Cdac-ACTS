import { Component, OnInit } from '@angular/core';
import { StudentService } from '.././student.service';
import { Student } from '.././Student';
import { formatDate } from '@angular/common';
import { NgForm } from '@angular/forms';
import { error } from 'protractor';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students:Student[]=[];
  student=new Student(0,'Null','Null','Null',new Date(),0);

  constructor(private service:StudentService) { }

  ngOnInit(): void {
    this.getAllStudents();
  }

  getAllStudents() {
    this.service.getStudents().subscribe(
      data => this.students = data,
      error => console.log("error " + error)
    );

  }

  getStudentById(sid:String){
    this.service.fetchStudentById(+sid).subscribe(
      data => this.student =data
    );
  }

  addStudent(newStudent:NgForm){
    var newStud:Student=newStudent.value;
    this.service.addNewStudent(newStud).subscribe(
      (response)=>console.log(response),
      (error)=>console.log(error)
    );
  }


}
