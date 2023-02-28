import { Component, ViewChild } from '@angular/core';
import { Question } from '../question';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pending-questions',
  templateUrl: './pending-questions.component.html',
  styleUrls: ['./pending-questions.component.css']
})
export class PendingQuestionsComponent {

  question = new Question();
  response:any = [];

  constructor(private _service:ServicesService, private _router: Router){

  }
  ngOnInit(){
      this._service.pendingQuestion().subscribe(
        data => {
          console.log(data)
          this.response = data
          console.log(this.response);
        },
        error => {
          console.log("exception occurred!!!!")
      }
    );
  }

  updateQuestionStatus(updateId){
    this._service.questionUpdate(updateId);
  }

  deleteQuestion(deleteId:number){
    this._service.questionDelete(deleteId);
  }

}

export interface QuestionInterface {
  id:number;
  img_src:string;
  topic: string;
  title: string;
  description_question: string;
  qcreated_by:string;
  datetime: string;
}

