import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {

  userEmail: any;
  user: User;


  constructor(public userService: UserService, private router: Router, private popUpService: PopUpService) {
    this.user = new User(0, '', '', '', '', '', '');
  }

  ngOnInit() {

    if (this.userService.checkRole() === null)
      this.userService.gotoHome();

    this.userEmail = sessionStorage.getItem("validUserEmail");
    this.userService.getUserByEmail(this.userEmail)
      .subscribe(data => {
        this.user = data;
      }, error => {
        if (error.status === 403)
          this.popUpService.errorAlert("Invalid Email")
        else
          this.popUpService.errorAlert("Something went wrong")
      });
  }
  deleteProfile() {
    Swal.fire({
      title: "<p style='color:#008080;font-size:25px;font-family:cursive'>Are you sure?</p>",
      html: "<p style='color:#008080;font-size:20px;font-family:cursive'>You won't be able to recover this account!</p>",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#008080',
      cancelButtonColor: 'btn btn-danger',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.userService.deleteUser(this.user.id)
          .subscribe(data => {
            this.popUpService.confirmAlert("Profile has been deleted successfully")
            this.userService.logout();
            this.router.navigate(['/login']);
          }, error => {
            if (error.status === 400)
              this.popUpService.errorAlert("Failed to delete")
            else
              this.popUpService.errorAlert("Something went wrong")
          });
      }
      else this.router.navigate(['']);
    })
  }

}
