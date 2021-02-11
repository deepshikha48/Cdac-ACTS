import { TagContentType } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import b64toBlob from 'b64-to-blob';

import { Timestamp } from 'rxjs/internal/operators/timestamp';
import { MenuItem } from 'src/app/model/menu-item';
import { OrderService } from 'src/app/service/order.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-qr-code-generator',
  templateUrl: './qr-code-generator.component.html',
  styleUrls: ['./qr-code-generator.component.css']
})
export class QRCodeGeneratorComponent implements OnInit {

  cart: Map<string, MenuItem> = new Map<string, MenuItem>();
  totalBill: number = 0;
  public createdCode: any = null;
  orderId: any;

  constructor(private orderService: OrderService, private userService: UserService) {
    this.createdCode = '';
  }

  ngOnInit(): void {

    if (this.userService.checkRole() != "STUDENT")
      this.userService.gotoHome();

    this.totalBill = this.orderService.getPaymentAmount();
    this.cart = this.orderService.getAllOrderedItemList();
    this.orderId = sessionStorage.getItem("orderId");
    this.createdCode += new Date().toDateString() + "  " + new Date().toLocaleTimeString() + "\n";
    this.createdCode += "Order Id: " + this.orderId + "\n";
    this.cart.forEach(element => {
      this.createdCode += element.totalQuantity + " " + element.itemName + " for " + element.mealType + "\n";
    });
    this.createdCode += "Paid: " + this.totalBill;
    sessionStorage.removeItem("orderId");

  }


}
