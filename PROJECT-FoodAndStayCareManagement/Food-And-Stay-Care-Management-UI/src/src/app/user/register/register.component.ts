import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  show: boolean = false;
  roleBoolean = false;

  user1 = new User(0, '', '', '', '', '', '');

  constructor(private service: UserService, private router: Router, private popUpService: PopUpService) { }

  addUser(user: NgForm) {

    this.service.addUserDetails(user.value).subscribe(
      data => {
        this.user1 = data;
        this.popUpService.confirmAlert("Successfully registered")

        if (this.roleBoolean != true)
          this.gotoLogin();
        else
          this.router.navigate(['']);

      }, error => {
        if (error.status === 406)
          this.popUpService.errorAlert("Registration failed, Email or contact already exists");
        else
          this.popUpService.errorAlert("Something Went wrong");
        this.gotoRegister();
      }
    );
  }
   togglePasswordType() {
    this.show = !this.show;
  }

  ngOnInit(): void {
    if (sessionStorage.getItem("validUserRole") == 'ADMIN')
      this.roleBoolean = true;
  }
  gotoLogin() {
    this.router.navigate(['/login']);
  }
  gotoRegister() {
    this.router.navigate(['/register']);
  }
 

}
