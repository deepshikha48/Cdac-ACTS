import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Feedback } from '../model/feedback';
import { User } from '../model/user';
import { FeedbackService } from '../service/feedback.service';
import { PopUpService } from '../service/pop-up.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  rating = 0;
  description = '';
  buttonEnabled: Boolean = false;

  feedbackObject: Feedback = new Feedback(0, '', new Date(), null);
  constructor(private router: Router, private feedbackService: FeedbackService, private userService: UserService, private popUpService: PopUpService) { }

  ngOnInit(): void {

    if (this.userService.checkRole() === "ADMIN" || this.userService.checkRole() === null) {
      this.userService.gotoHome();
    }

  }
  submitFeedback() {

    if (this.description != '' || this.rating != 0) {

      this.feedbackObject.description = this.description;
      this.feedbackObject.rating = this.rating;
      this.feedbackService.addFeedback(this.feedbackObject).subscribe(data => {
        this.feedbackObject = data;
        sessionStorage.setItem("feedbackDate", this.feedbackObject.dateTime.toString());
        this.popUpService.confirmAlert("FSCM appreciates your feedback, " + sessionStorage.getItem("validUserName") + "!");
      },
        error => {
          if (error.status === 406)
            this.popUpService.errorAlert("Failed to submit your feedback");
          else
            this.popUpService.errorAlert("Something went wrong");
        });
    }
    this.router.navigate(['']);
  }
  radioChangeHandler(e: any) {
    this.buttonEnabled = true;
    this.rating = e.target.value;
  }

}
