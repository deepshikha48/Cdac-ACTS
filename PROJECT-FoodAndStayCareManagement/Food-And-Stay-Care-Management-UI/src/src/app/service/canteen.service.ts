import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MenuItem } from '../model/menu-item';

@Injectable({
  providedIn: 'root'
})
export class CanteenService {
  baseUrl: string = "http://localhost:8080/menu";

  constructor(private http: HttpClient) { }

  //fetch today's menu for student
  getCanteenMenu(): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(this.baseUrl);
  }

  getDays(): Observable<String[]> {
    return this.http.get<String[]>(this.baseUrl + "/days");
  }

  getMealTypes(): Observable<String[]> {
    return this.http.get<String[]>(this.baseUrl + "/mealtypes");
  }

  getCanteenMenuForOwner(day: string, mealType: string): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(this.baseUrl + "/" + day + "/" + mealType);
  }

  getMenuItemByid(id: number): Observable<MenuItem> {
    return this.http.get<MenuItem>(this.baseUrl + "/id/" + id);
  }

  updateMenuItem(menu: MenuItem): Observable<MenuItem> {
    return this.http.put<MenuItem>(this.baseUrl, menu);
  }

  deleteMenuItem(id: number) {
    return this.http.delete(this.baseUrl + "/" + id);
  }

  addNewMenuItem(newMenuItem: MenuItem) {
    return this.http.post(this.baseUrl, newMenuItem);
  }

}