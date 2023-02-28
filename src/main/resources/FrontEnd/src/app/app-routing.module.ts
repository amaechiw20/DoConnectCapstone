import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SearchQuestionComponent } from './search-question/search-question.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { PendingQuestionsComponent } from './pending-questions/pending-questions.component';
import { AuthGuard } from './auth.guard';
import { PendingAnswerComponent } from './pending-answer/pending-answer.component';
import { ShowChatComponent } from './show-chat/show-chat.component';
import { QuestionDetailComponent } from './question-detail/question-detail.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent },
  { path: 'loginadmin', component: AdminLoginComponent},
  { path: 'userdashboard', component: UserDashboardComponent, canActivate: [AuthGuard]},
  { path: 'searchquestion', component: SearchQuestionComponent, canActivate: [AuthGuard]},
  { path: 'pendingquestions', component: PendingQuestionsComponent, canActivate: [AuthGuard]},
  { path: 'pendinganswers', component: PendingAnswerComponent, canActivate: [AuthGuard]},
  { path: 'chatwithus', component: ShowChatComponent, canActivate: [AuthGuard]},
  { path: 'questiondetail', component: QuestionDetailComponent, canActivate: [AuthGuard]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
