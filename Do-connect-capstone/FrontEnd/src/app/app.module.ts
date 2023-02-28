import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { MatIconModule } from "@angular/material/icon"
import { FormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginSignupComponent } from './login/login-signup.component';
import { HttpClientModule, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserNavbarComponent } from './user-navbar/user-navbar.component';
import { DatePipe } from '@angular/common';
import { SearchQuestionComponent } from './search-question/search-question.component';
import { MatTableModule } from '@angular/material/table'
import { MatPaginatorModule } from '@angular/material/paginator'
import { MatButtonModule } from '@angular/material/button';
import { PendingQuestionsComponent } from './pending-questions/pending-questions.component'
import { AuthGuard } from './auth.guard';
import { PendingAnswerComponent } from './pending-answer/pending-answer.component';
import { ShowChatComponent } from './show-chat/show-chat.component';
import { ChatComponent } from './chat/chat.component';
import { QuestionDetailComponent } from './question-detail/question-detail.component';
import { TokenInterceptorService } from './token-interceptor.service';
import { ServicesService } from './services.service';
import { SignUpComponent } from './sign-up/sign-up.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    LoginSignupComponent,
    AdminLoginComponent,
    AdminNavbarComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    UserNavbarComponent,
    SearchQuestionComponent,
    PendingQuestionsComponent,
    PendingAnswerComponent,
    ShowChatComponent,
    ChatComponent,
    QuestionDetailComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    HttpClientModule,
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatButtonModule,
  ],
  providers: [
    DatePipe, AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    ServicesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
