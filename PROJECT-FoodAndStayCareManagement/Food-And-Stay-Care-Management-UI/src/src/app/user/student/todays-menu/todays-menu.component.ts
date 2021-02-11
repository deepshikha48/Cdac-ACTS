import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'src/app/model/menu-item';
import { CanteenService } from 'src/app/service/canteen.service';
import { OrderService } from 'src/app/service/order.service';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-todays-menu',
  templateUrl: './todays-menu.component.html',
  styleUrls: ['./todays-menu.component.css']
})
export class TodaysMenuComponent implements OnInit {

  menu: MenuItem[] = [];
  cart: Map<string, MenuItem> = new Map<string, MenuItem>();

  constructor(private orderService: OrderService, private route: Router, private canteenService: CanteenService, private popUpService: PopUpService, private userService: UserService) { }

  ngOnInit(): void {

    if (this.userService.checkRole() != "STUDENT")
      this.userService.gotoHome();
    this.getTodaysMenu();
  }

  getTodaysMenu() {
    this.canteenService.getCanteenMenu().subscribe(
      data => {
        this.menu = data;
        if (data == null)
          this.popUpService.emptyListAlert("We are closed, check after sometime");
      },
      error => {//Backend returns unsuccessful response codes such as 404, 500 etc.				 

        this.popUpService.errorAlert("Something Went wrong");
        this.userService.gotoHome();
      }
    );
  }

  addItemIntoCart(item: MenuItem, totalQuantity: string) {
    let menuItem: MenuItem = new MenuItem(0, '', 0, '', 0, '', '');

    let tempQuantity = parseInt(totalQuantity);

    if (tempQuantity > 0 && item.totalQuantity >= tempQuantity) {
      menuItem.id = item.id;
      menuItem.itemName = item.itemName;
      menuItem.day = item.day;
      menuItem.description = item.description;
      menuItem.mealType = item.mealType;
      menuItem.price = item.price;
      menuItem.totalQuantity = tempQuantity;
      this.cart.set(item.itemName, menuItem);
      this.orderService.addIntoCart(this.cart)
      this.popUpService.addToCartAlert("Added successfully");
    }
    else
      this.popUpService.errorAlert("Invalid quantity!");

  }



}

