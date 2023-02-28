import { Component } from '@angular/core';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-question-detail',
  templateUrl: './question-detail.component.html',
  styleUrls: ['./question-detail.component.css']
})
export class QuestionDetailComponent {

  response:any = [];
  constructor(private _service:ServicesService, private _router: Router){

  }
  ngOnInit(){
    this._service.detailQuestion().subscribe(res =>{
      this.response = res
    })
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

