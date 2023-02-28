import { Component, ViewChild } from '@angular/core';
import { Question } from '../question';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-question',
  templateUrl: './search-question.component.html',
  styleUrls: ['./search-question.component.css']
})

export class SearchQuestionComponent {
  id:number;
  question = new Question();
  response:any = [];
  constructor(private _service:ServicesService, protected _router: Router){

  }

  ngOnInit(){
    this._service.allQuestions().subscribe(
      data => {
        console.log("response recieved")
        this.response = data
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
      },
      error => {
        console.log("exception occurred")
      }
    )
  }

  setId(showId:number){
    this.id = showId;
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
