import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  userEmail: any;
  user: User;

  constructor(private userService: UserService, private router: Router, private popUpService: PopUpService) {

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

  updateUserProfile() {
    this.userService.updateUserDetails(this.user)
      .subscribe(data => {
        this.popUpService.confirmAlert("Profile has been updated successfully");
      }, error => {
        if (error.status === 403)
          this.popUpService.errorAlert("Failed to update profile")
        else
          this.popUpService.errorAlert("Something went wrong")
      });
    if (this.user.role == "STUDENT")
      this.gotoTodaysMenuForStudent();
    else
      this.gotoShowMenuForOwner();
  }

  onSubmit() {
    this.updateUserProfile();
  }

  gotoShowMenuForOwner() {
    this.router.navigate(['/showmenu']);
  }
  gotoTodaysMenuForStudent() {
    this.router.navigate(['/todaysmenu']);
  }
}  
