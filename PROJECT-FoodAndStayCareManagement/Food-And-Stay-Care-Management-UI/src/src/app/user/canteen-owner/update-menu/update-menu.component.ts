import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuItem } from 'src/app/model/menu-item';
import { CanteenService } from 'src/app/service/canteen.service';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-update-menu',
  templateUrl: './update-menu.component.html',
  styleUrls: ['./update-menu.component.css']
})
export class UpdateMenuComponent implements OnInit {
  id: number;
  menu: MenuItem;

  constructor(private route: ActivatedRoute,
    private service: CanteenService, private router: Router, private popUpService: PopUpService, private userService: UserService) {

    this.menu = new MenuItem(0, "", 0, "", 0, "", "");
    this.id = 0;
  }

  ngOnInit() {

    if (this.userService.checkRole() != "CANTEEN_OWNER")
      this.userService.gotoHome();

    this.id = this.route.snapshot.params['id'];

    this.service.getMenuItemByid(this.id)
      .subscribe(data => {
        this.menu = data;
      }, error => {
        if (error.status === 400)
          this.popUpService.errorAlert("Item not found")
        else
          this.popUpService.errorAlert("Something went wrong")
      });
  }

  updateMenuItem() {
    this.service.updateMenuItem(this.menu)
      .subscribe(data => {
        this.popUpService.confirmAlert("Item has been updated successfully");
      }, error => {
        if (error.status === 403)
          this.popUpService.errorAlert("Failed to update")
        else
          this.popUpService.errorAlert("Something went wrong")
      });
    this.gotoList();
  }

  onSubmit() {
    this.updateMenuItem();
  }

  cancelUpdate() {
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/showmenu']);
  }
}  
