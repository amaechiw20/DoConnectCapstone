import { Component, ViewChild } from '@angular/core';
import { Question } from '../question';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-search-question',
  templateUrl: './search-question.component.html',
  styleUrls: ['./search-question.component.css']
})

export class SearchQuestionComponent {
  question = new Question();
  response:any = [];
  constructor(private _service:ServicesService, protected _router: Router){

  }

  ngOnInit(){
    this._service.allQuestions().subscribe(
      data => {
        console.log(data)
        this.response = data
        console.log(this.response);
      },
      error => {
        console.log("exception occurred")
      }
    );
  }
  
  searchQuestion(){
    this._service.questionSearch(this.question).subscribe(
      data => {
        console.log("response recieved")
        this.response = data;
        console.log(data)
      },
      error => {
        console.log("exception occurred")
      }
    )
  }
}

export interface QuestionInterface {
  id:number;
  topic: string;
  title: string;
  description_question: string;
  status: string;
  img_src: string;
  datetime: string;

}
