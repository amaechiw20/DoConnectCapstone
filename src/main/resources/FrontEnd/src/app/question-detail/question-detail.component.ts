import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-question-detail',
  templateUrl: './question-detail.component.html',
  styleUrls: ['./question-detail.component.css'],
})
export class QuestionDetailComponent {
  response = [];
  displayedColumns: string[] = ['id', 'title', 'topic', 'description_question'];
  dataSource = new MatTableDataSource<QuestionInterface>(this.response);
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  constructor(private _service: ServicesService, private _router: Router) {}
  ngOnInit() {
    this._service.detailQuestion().subscribe((res) => {
      this.response = res;
    });
  }
}

export interface QuestionInterface {
  id: number;
  img_src: string;
  topic: string;
  title: string;
  description_question: string;
  qcreated_by: string;
  datetime: string;
}
