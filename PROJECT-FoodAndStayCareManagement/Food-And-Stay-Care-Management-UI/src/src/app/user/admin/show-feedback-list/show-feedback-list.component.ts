import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Feedback } from 'src/app/model/feedback';
import { FeedbackService } from 'src/app/service/feedback.service';
import { PopUpService } from 'src/app/service/pop-up.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-show-feedback-list',
  templateUrl: './show-feedback-list.component.html',
  styleUrls: ['./show-feedback-list.component.css']
})
export class ShowFeedbackListComponent implements OnInit {

  feedbackList: Feedback[] = [];
  constructor(private feedbackService: FeedbackService, private router: Router, private popUpService: PopUpService, private userService: UserService) { }

  ngOnInit(): void {
    if (this.userService.checkRole() != "ADMIN")
      this.userService.gotoHome();

    this.feedbackService.getAllFeedback().subscribe(
      data => {
        if (data == null) {
          this.popUpService.emptyListAlert("No feedback available")
          this.router.navigate(['']);
        }
        this.feedbackList = data;
      },
      error => {
        this.popUpService.errorAlert("Something went wrong");
      }
    );
  }

}
