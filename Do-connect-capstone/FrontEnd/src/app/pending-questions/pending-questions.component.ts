import { Component, ViewChild } from '@angular/core';
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

  response:any = [];
  constructor(private _service:ServicesService, private _router: Router){

  }
  ngOnInit(){
    this._service.pendingQuestion().subscribe(res =>{
        this.response = res;
    })
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

