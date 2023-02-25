import { Component, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Router } from '@angular/router';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-show-chat',
  templateUrl: './show-chat.component.html',
  styleUrls: ['./show-chat.component.css']
})
export class ShowChatComponent {

  response = [];
  displayedColumns: string[] = ['id',"name","action"];
  dataSource = new MatTableDataSource<UserInterface>(this.response);
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  constructor(protected _router: Router){
  
  }


}

export interface UserInterface{
  id:number;
  name:String;
  username:String;
  email: String;
  password: String;
  usertype:string;
}