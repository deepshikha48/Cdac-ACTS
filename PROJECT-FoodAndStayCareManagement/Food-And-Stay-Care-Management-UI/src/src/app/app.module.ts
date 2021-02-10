import { BrowserModule } from '@angular/platform-browser';


import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './user/login/login.component';
import { FooterComponent } from './footer/footer.component';
import { RegisterComponent } from './user/register/register.component';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { TodaysMenuComponent } from './user/student/todays-menu/todays-menu.component';
import { UserService } from './service/user.service';
import { OrderService } from './service/order.service';
import { CanteenService } from './service/canteen.service';
import { ShowMenuComponent } from './user/canteen-owner/show-menu/show-menu.component';
import { AddMenuComponent } from './user/canteen-owner/add-menu/add-menu.component';
import { UpdateMenuComponent } from './user/canteen-owner/update-menu/update-menu.component';
import { CartComponent } from './user/student/cart/cart.component';
import { PaymentComponent } from './user/student/payment/payment.component';
import { LogoutComponent } from './user/logout/logout.component';
import { PageNotFoundComponent } from './error/page-not-found/page-not-found.component';
import { ViewProfileComponent } from './user/profile/view-profile/view-profile.component';
import { UpdateProfileComponent } from './user/profile/update-profile/update-profile.component';
import { QRCodeGeneratorComponent } from './user/student/qr-code-generator/qr-code-generator.component';
import { AnQrcodeModule } from 'an-qrcode';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { ChangePasswordComponent } from './user/profile/change-password/change-password.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FeedbackService } from './service/feedback.service';
import { ShowFeedbackListComponent } from './user/admin/show-feedback-list/show-feedback-list.component';
import { ShowUserListComponent } from './user/admin/show-user-list/show-user-list.component';
import { PopUpService } from './service/pop-up.service';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AboutUsComponent,
    ContactUsComponent,
    TodaysMenuComponent,
    ShowMenuComponent,
    AddMenuComponent,
    UpdateMenuComponent,
    CartComponent,
    PaymentComponent,
    LogoutComponent,
    PageNotFoundComponent,
    ViewProfileComponent,
    UpdateProfileComponent,
    QRCodeGeneratorComponent,
    ForgotPasswordComponent,
    ChangePasswordComponent,
    FeedbackComponent,
    ShowFeedbackListComponent,
    ShowUserListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AnQrcodeModule
  ],
  providers: [UserService, OrderService, CanteenService,FeedbackService,PopUpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
