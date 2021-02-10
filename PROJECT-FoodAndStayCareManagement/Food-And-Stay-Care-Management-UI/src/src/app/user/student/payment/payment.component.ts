import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/service/order.service';
import { Payment } from 'src/app/model/payment';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  cardDetails: Payment = new Payment('', '', new Date(), '');
  totalBill: number = 0;
  date: String = new Date().toISOString().slice(0, 10);

  orderId: number = 0;
  userEmail: any;
  str: any = '';

  user = new User(0, '', '', '', '', '', '');

  constructor(private orderService: OrderService, private route: Router, private userService: UserService, private popUpService: PopUpService) { }

  ngOnInit(): void {

    if (this.userService.checkRole() != "STUDENT")
      this.userService.gotoHome();

    this.str = sessionStorage.getItem("validUserId");
    this.user.id = parseInt(this.str);
    this.getAmountToPay();
  }

  getAmountToPay() {
    this.totalBill = this.orderService.getPaymentAmount();
  }

  cancelPayment() {
    this.gotoCanteenMenu();
  }
  payAmount() {
    this.orderService.orderConfirmed(this.user.id).subscribe(
      data => {
        this.orderId = data;
        sessionStorage.setItem("orderId", this.orderId.toString());
        this.popUpService.confirmAlert("Order placed with order No.: " + this.orderId);
        this.route.navigate(['/qrcode']);

      }, error => {
        if (error.status === 406)
          this.popUpService.errorAlert("Order Cancelled")
        else
          this.popUpService.errorAlert("Something went wrong")
        this.gotoCanteenMenu();
      });

  }

  gotoCanteenMenu() {

    this.route.navigate(['/todaysmenu']);
  }



}