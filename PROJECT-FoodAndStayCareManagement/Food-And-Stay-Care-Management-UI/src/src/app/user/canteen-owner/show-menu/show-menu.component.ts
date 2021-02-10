import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MenuItem } from 'src/app/model/menu-item';
import { CanteenService } from 'src/app/service/canteen.service';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-show-menu',
  templateUrl: './show-menu.component.html',
  styleUrls: ['./show-menu.component.css']
})
export class ShowMenuComponent implements OnInit {

  days: String[] = [];
  mealTypes: String[] = [];
  menu: MenuItem[] = [];
  day: string = '';
  mealType: string = '';

  constructor(private service: CanteenService, private router: Router, private popUpService: PopUpService, private userService: UserService) { }

  ngOnInit(): void {

    if (this.userService.checkRole() != "CANTEEN_OWNER")
      this.userService.gotoHome();

    this.service.getDays().subscribe(
      data => this.days = data,
      error => {
       
          this.popUpService.errorAlert("Something went wrong");
      }
    );

    this.service.getMealTypes().subscribe(
      data => this.mealTypes = data,
      error => {
      
          this.popUpService.errorAlert("Something went wrong");
      }
    );
  }

  getMenu(day: string, mealType: string) {
    //to reset the earlier value then add new data
    this.day = day;
    this.mealType = mealType;
    this.service.getCanteenMenuForOwner(day, mealType).subscribe(
      data => {
        //to empty the earlier array then add new data
        this.menu = [];
        if (data == null)
          this.popUpService.emptyListAlert("No items available")
        else
          this.menu = data;
      },
      error => {
        if (error.status === 500)
          this.popUpService.errorAlert("Something went wrong")
      }
    );
  }

  addnewitem(day: string, mealType: string) {

    this.router.navigate(['addmenu', day, mealType]);
  }
  gotoList() {
    this.router.navigate(['/showmenu']);
  }

  deleteMenu(id: number) {

    Swal.fire({
      title: "<p style='color:#008080;font-size:30px;font-family:cursive'>Are you sure?</p>",
      html: "<p style='color:#008080;font-size:25px;font-family:cursive'>You won't be able to revert this!</p>",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#008080',
      cancelButtonColor: 'btn btn-danger',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.deleteMenuItem(id)
          .subscribe(data => {
            this.popUpService.confirmAlert("Item has been deleted successfully");
            this.getMenu(this.day, this.mealType);
          }, error => {
            if (error.status === 400)
              this.popUpService.errorAlert("Failed to delete")
            else
              this.popUpService.errorAlert("Something went wrong")
          });
      }
      this.router.navigate(['/showmenu']);
    })

  }
}


