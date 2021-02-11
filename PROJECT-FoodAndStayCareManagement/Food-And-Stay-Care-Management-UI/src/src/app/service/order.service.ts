import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MenuItem } from '../model/menu-item';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl: string = "http://localhost:8080/order";

  cart: Map<string, MenuItem> = new Map<string, MenuItem>();
  totalBill: number = 0;
  menuItems: MenuItem[] = [];
  orderId: any;


  constructor(private http: HttpClient) { }

  orderNowAllItems(mapOfMenuItems: Map<string, MenuItem>) {
    this.cart = mapOfMenuItems;
  }
  orderConfirmed(id: number): Observable<number> {
    this.menuItems = [];
    for (let item of this.cart.values()) {
      this.menuItems.push(item);
    }
    return this.http.post<number>(this.baseUrl + "/" + id, this.menuItems);
  }

  addIntoCart(mapOfMenuItems: Map<string, MenuItem>) {
    this.cart = mapOfMenuItems;
    this.totalBill = 0;
    for (let value of this.cart.values()) {
      this.totalBill += value.totalQuantity * value.price;
    }
  }

  getAllOrderedItemList(): Map<string, MenuItem> {
    return this.cart;
  }
  
  getPaymentAmount(): number {
    return this.totalBill;
  }
}

