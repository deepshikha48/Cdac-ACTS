import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {

    if (this.userService.checkRole() === "ADMIN" || this.userService.checkRole() === null) {
      this.userService.gotoHome();
    }
  }

}
