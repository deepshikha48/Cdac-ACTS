import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { PageNotFoundComponent } from './error/page-not-found/page-not-found.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { HomeComponent } from './home/home.component';
import { ShowFeedbackListComponent } from './user/admin/show-feedback-list/show-feedback-list.component';
import { ShowUserListComponent } from './user/admin/show-user-list/show-user-list.component';
import { AddMenuComponent } from './user/canteen-owner/add-menu/add-menu.component';
import { ShowMenuComponent } from './user/canteen-owner/show-menu/show-menu.component';
import { UpdateMenuComponent } from './user/canteen-owner/update-menu/update-menu.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { LoginComponent } from './user/login/login.component';
import { LogoutComponent } from './user/logout/logout.component';
import { ChangePasswordComponent } from './user/profile/change-password/change-password.component';
import { UpdateProfileComponent } from './user/profile/update-profile/update-profile.component';
import { ViewProfileComponent } from './user/profile/view-profile/view-profile.component';
import { RegisterComponent } from './user/register/register.component';
import { PaymentComponent } from './user/student/payment/payment.component';
import { QRCodeGeneratorComponent } from './user/student/qr-code-generator/qr-code-generator.component';
import { TodaysMenuComponent } from './user/student/todays-menu/todays-menu.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'forgotpassword', component:ForgotPasswordComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'contact', component: ContactUsComponent },
  { path: 'about', component: AboutUsComponent },
  { path: 'todaysmenu', component: TodaysMenuComponent },
  { path: 'updatemenu/:id', component: UpdateMenuComponent },
  { path: 'showmenu', component: ShowMenuComponent },
  { path: 'addmenu/:day/:mealType', component: AddMenuComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'viewprofile', component: ViewProfileComponent },
  { path: 'updateprofile', component: UpdateProfileComponent },
  { path: 'changepassword', component: ChangePasswordComponent},
  { path: 'logout', component: LogoutComponent },
  { path: 'feedback', component: FeedbackComponent},
  { path: 'qrcode', component: QRCodeGeneratorComponent },
  { path: 'feedbacklist', component: ShowFeedbackListComponent },
  { path: 'userlist', component: ShowUserListComponent },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, LoginComponent, RegisterComponent, ContactUsComponent, AboutUsComponent, TodaysMenuComponent,
  UpdateMenuComponent, ShowMenuComponent, AddMenuComponent,FeedbackComponent,ShowUserListComponent,ShowFeedbackListComponent, PaymentComponent, LogoutComponent, QRCodeGeneratorComponent, PageNotFoundComponent, ViewProfileComponent, UpdateProfileComponent,ChangePasswordComponent,ForgotPasswordComponent];

