import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  userEmail: any;
  user: User;
  newPassword: string = '';
  confirmPassword: string = '';
  show:boolean=false;

  constructor(private userService: UserService, private router: Router, private popUpService: PopUpService) {

    this.user = new User(0, '', '', '', '', '', '');

  }

  ngOnInit() {

    if (this.userService.checkRole() === null)
      this.userService.gotoHome();

    this.userEmail = sessionStorage.getItem("validUserEmail");

    this.userService.getUserByEmail(this.userEmail)
      .subscribe(data => {
        console.log(data)
        this.user = data;
      }, error => {
        if (error.status === 403)
          this.popUpService.errorAlert("Invalid Email")
        else
          this.popUpService.errorAlert("Something went wrong")
      });
  }

  changePassword() {
    if (this.newPassword != this.confirmPassword) {
      this.newPassword = '';
      this.confirmPassword = '';
      this.popUpService.errorAlert("Password Mismatch")
      this.gotoChangePassword();
    }
    else {
      this.user.password = this.newPassword;
      this.userService.updateUserDetails(this.user)
        .subscribe(data => {
            this.popUpService.confirmAlert("Password has been updated successfully");
        }, error => {
          if (error.status === 403)
          this.popUpService.errorAlert("Failed to update password");
          else
            this.popUpService.errorAlert("Something went wrong")
        });
      this.userService.logout();
      this.router.navigate(['login']);
    }
  }
  onSubmit() {
    this.changePassword();
  }
  gotoChangePassword() {
    this.router.navigate(['/changepassword']);
  }

  password() {
    this.show = !this.show;
}



}
