import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    if (this.userService.checkRole() === "ADMIN" || this.userService.checkRole() === null) {
      this.userService.gotoHome();
    }
  }

}
