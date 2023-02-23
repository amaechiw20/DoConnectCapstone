import { Component, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pending-answer',
  templateUrl: './pending-answer.component.html',
  styleUrls: ['./pending-answer.component.css']
})
export class PendingAnswerComponent {
  response = [];
  displayedColumns: string[] = ['id','description', 'acreated_by', 'datetime',"action"];
  dataSource = new MatTableDataSource<AnswerInterface>(this.response);
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  constructor(private _service:ServicesService, private _router: Router){

  }
  ngOnInit(){
    this._service.pendingAnswer().subscribe(res =>{
        this.response = res;
    })
  }

  updateAnswerStatus(updateId){
    this._service.answerUpdate(updateId);
  }

  deleteAnswer(deleteId){
    this._service.answerDelete(deleteId);
  }

}

export interface AnswerInterface {
  id:number;
  description: string;
  acreated_by:string;
  datetime: string;
}

