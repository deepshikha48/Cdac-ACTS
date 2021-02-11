import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CanteenService } from 'src/app/service/canteen.service';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit {

  day: string = '';
  mealType: string = '';

  constructor(private route: ActivatedRoute,
    private service: CanteenService, private router: Router, private popUpService: PopUpService, private userService: UserService) {
  }

  ngOnInit() {

    if (this.userService.checkRole() != "CANTEEN_OWNER")
      this.userService.gotoHome();

    this.day = this.route.snapshot.params['day'];
    this.mealType = this.route.snapshot.params['mealType'];
  }

  addNewItem(menuItem: NgForm) {
    this.service.addNewMenuItem(menuItem.value).subscribe(
      data => {
        this.popUpService.confirmAlert("Item added successfully")
        this.gotoList();
      },
      error => {
        if (error.status == 406) {
          this.popUpService.errorAlert("Failed to add new item")
          this.router.navigate(['/addmenu', this.day, this.mealType]);
        } else
          this.popUpService.errorAlert("Something went wrong")
      }
    );
  }

  gotoList() {
    this.router.navigate(['/showmenu']);
  }

}