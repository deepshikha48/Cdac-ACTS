import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl: string = "http://localhost:8080/user";

  constructor(private http: HttpClient, private router: Router) { }

  authenticateUserDetails(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl + "/login", user).pipe(map(resp => {
      sessionStorage.setItem("validUserEmail", user.email);
      return resp;
    }));
  }

  isUserLoggedIn(): boolean {
    let flag = true;
    if (sessionStorage.getItem("validUserEmail") === null)
      flag = false;
    return flag;
  }

  ifUserNotLoggedInThenGotoLogIn() {
    if (sessionStorage.getItem("validUserId") === null)
      this.router.navigate(['/login']);
     }
  gotoHome(){
    this.router.navigate(['']);
  }

  checkRole(): any {
      return sessionStorage.getItem("validUserRole"); 
  }
  
  isFeedbackGiven(): boolean {
    let flag = true;
    if (sessionStorage.getItem("feedbackDate") === null)
      flag = false;
    return flag;
  }
   
  logout(): void {
    sessionStorage.removeItem("validUserEmail");
    sessionStorage.removeItem("validUserId");
    sessionStorage.removeItem("validUserName");
    sessionStorage.removeItem("validUserRole");
    sessionStorage.removeItem("feedbackDate");
  }
  addUserDetails(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl, user);
  }
  getUserByEmail(email: string): Observable<User> {
    return this.http.post<User>(this.baseUrl + "/search", email);
  }

  updateUserDetails(user: User): Observable<User> {
    return this.http.put<User>(this.baseUrl, user);
  }

  deleteUser(id: number) {
    return this.http.delete(this.baseUrl + "/" + id);
  }
  

  forgotPasswordDetails(email: String): Observable<String> {
    return this.http.post<String>(this.baseUrl + "/forgotpassword", email);
  }

  getAllRoles(): Observable<String[]> {
    return this.http.get<String[]>(this.baseUrl + "/roles");
  }

  getUserList(role:string):Observable<User[]>{
    return this.http.get<User[]>(this.baseUrl+"/list/"+role);
  }


}
