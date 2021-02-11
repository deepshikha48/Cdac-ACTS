import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User(0, '', '', '', '', '', '');

  constructor(private service: UserService, private router: Router, private popUpService: PopUpService) { }

  authenticateUser(user: NgForm) {
    this.service.authenticateUserDetails(user.value).subscribe(
      data => {
        this.user = data;
        this.popUpService.simpleAlert("Welcome " + this.user.firstName);
        sessionStorage.setItem("validUserId", this.user.id.toString());
        sessionStorage.setItem("validUserName", this.user.firstName);
        sessionStorage.setItem("validUserRole", this.user.role);
        if (this.user.role == "STUDENT")
          this.gotoStudentHome();
        else if (this.user.role == "CANTEEN_OWNER")
          this.gotoCanteenOwnerHome();
        else
          this.gotoHome();
      },
      error => {//Backend returns unsuccessful response codes such as 404, 500 etc.				 
        if (error.status === 401)
          this.popUpService.errorAlert("Invalid credentials");
        else
          this.popUpService.errorAlert("Something went wrong");
        this.gotoLogin();

      }

    );
  }

  ngOnInit(): void {
    if (this.service.checkRole() === 'ADMIN')
      this.router.navigate(['']);

  }
  gotoStudentHome() {
    this.router.navigate(['/todaysmenu']);
  }
  gotoLogin() {
    this.router.navigate(['/login']);
  }
  gotoCanteenOwnerHome() {
    this.router.navigate(['/showmenu']);
  }
  gotoHome() {
    this.router.navigate(['']);
  }


}


