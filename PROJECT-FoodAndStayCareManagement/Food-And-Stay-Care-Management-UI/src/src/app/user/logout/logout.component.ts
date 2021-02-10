import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private userService: UserService, private router: Router, private popUpService: PopUpService) { }

  ngOnInit() {

    if (this.userService.checkRole() === null)
      this.userService.gotoHome();

    this.popUpService.simpleAlert("Thanks for visit");
    this.userService.logout();
    this.router.navigate(['login']);
  }
}
