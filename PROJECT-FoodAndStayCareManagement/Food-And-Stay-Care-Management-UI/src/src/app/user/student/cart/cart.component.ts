import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'src/app/model/menu-item';
import { OrderService } from 'src/app/service/order.service';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart:Map<string, MenuItem> = new Map<string, MenuItem>();
  totalBill:number=0; 
  menuItems:MenuItem[]=[];

  constructor(private orderService: OrderService,private route:Router,private popUpService:PopUpService,private userService:UserService){}

  ngOnInit(): void {

    if(this.userService.checkRole()!="STUDENT")
      this.userService.gotoHome();
  
    }

  getAllOrderedItemList() 
  {
    this.cart=this.orderService.getAllOrderedItemList();
    this.menuItems=[];
    this.cart.forEach(element => {
     this.menuItems.push(element);
   });
    this.totalBill=this.orderService.getPaymentAmount();
  }
  cancelOrder(){
    this.cart.clear();
    this.orderService.addIntoCart(this.cart);
  }
  
  
  payAmount(){
    if(this.cart.size==0){
      this.popUpService.emptyListAlert("Your cart is empty");
    }
    else{
      this.orderService.orderNowAllItems(this.cart);
      this.gotoPaymentPage();
    }
    
  }
  gotoCanteenMenu() {
    this.route.navigate(['/todaysmenu']);
  }
  gotoPaymentPage() {
    this.route.navigate(['/payment']);
  }
}