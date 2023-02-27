import { Component } from '@angular/core';
import { Question } from '../question';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent {
  question = new Question();
  msgRS = '';
  msgRF = '';
  constructor(
    private _service: ServicesService,
    private _router: Router,
    private date: DatePipe
  ) {}

  ngOnInit() {}
  createQuestion() {
    this.question.datetime = this.date.transform(
      new Date(),
      'MM/dd/yyyy h:mm:ss'
    );
    this._service.questionCreate(this.question).subscribe(
      (data) => {
        console.log('response recieved');
        this.msgRS = 'Question created succesfully!';
      },
      (error) => {
        console.log('exception occurred');
        this.msgRF = 'Question not created, please try again!';
      }
    );
  }
}
