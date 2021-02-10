import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  user = new User(0, '', '', '', '', '', '');
  

  constructor(private service: UserService, private router: Router, private popUpService: PopUpService) { }

  ngOnInit(): void {
  }

  forgotpassword(user: NgForm) {
    this.service.forgotPasswordDetails(user.value.email).subscribe(
      data => {
        this.popUpService.simpleAlert("Password has been sent to your Email Id");
        this.gotoLogin();
      },
      error => {
        //Backend returns unsuccessful response codes such as 404, 500 etc.				 
        if (error.status === 401)
          this.popUpService.errorAlert("Invalid Email")
        else
          this.popUpService.errorAlert("Something went wrong")

        this.gotoForgotPassword();
      });
  }

  gotoLogin() {
    this.router.navigate(['/login']);
  }
  gotoForgotPassword() {
    this.router.navigate(['/forgotpassword']);
  }


}
