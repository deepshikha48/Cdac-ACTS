import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-show-user-list',
  templateUrl: './show-user-list.component.html',
  styleUrls: ['./show-user-list.component.css']
})
export class ShowUserListComponent implements OnInit {

  roles: String[] = [];
  role: string = '';
  users: User[] = [];
  constructor(private userService: UserService, private popUpService: PopUpService, private router: Router) { }

  ngOnInit(): void {

    if (this.userService.checkRole() != "ADMIN")
      this.userService.gotoHome();

    this.userService.getAllRoles().subscribe(
      data => this.roles = data,
      error => this.popUpService.emptyListAlert("Something went wrong")
    );
  }
  getUsersByRole(role: string) {
    //to reset the earlier value then add new data
    this.role = role;
    this.userService.getUserList(role).subscribe(
      data => {
        //to empty the earlier array then add new data
        this.users = [];
        if (data == null)
          this.popUpService.emptyListAlert("No users available")
        else
          this.users = data;
      },
      error => this.popUpService.emptyListAlert("Something went wrong")
    );
  }
  deleteProfile(id: number) {
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
        this.userService.deleteUser(id)
          .subscribe(data => {
            this.popUpService.confirmAlert("Profile has been deleted successfully")
          }, 
          error => 
          this.popUpService.errorAlert("Something went wrong"));
      }
      this.router.navigate(['/userlist']);
    })
  }
  addNewCanteenOwner() {
    this.router.navigate(['/register']);
  }
}
