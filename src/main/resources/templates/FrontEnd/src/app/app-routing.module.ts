import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomeComponent } from './home/home.component';
import { LoginSignupComponent } from './login-signup/login-signup.component';
import { SearchQuestionComponent } from './search-question/search-question.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { PendingQuestionsComponent } from './pending-questions/pending-questions.component';
import { AuthGuard } from './auth.guard';
import { PendingAnswerComponent } from './pending-answer/pending-answer.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent },
  { path: 'loginsignupuser', component: LoginSignupComponent},
  { path: 'loginadmin', component: AdminLoginComponent},
  { path: 'admindashboard', component: AdminDashboardComponent, canActivate: [AuthGuard]},
  { path: 'userdashboard', component: UserDashboardComponent, canActivate: [AuthGuard]},
  { path: 'searchquestion', component: SearchQuestionComponent, canActivate: [AuthGuard]},
  { path: 'pendingquestion', component: PendingQuestionsComponent, canActivate: [AuthGuard]},
  { path: 'pendinganswer', component: PendingAnswerComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }