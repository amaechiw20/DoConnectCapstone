import { Component } from '@angular/core';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-admin-navbar',
  templateUrl: './admin-navbar.component.html',
  styleUrls: ['./admin-navbar.component.css']
})
export class AdminNavbarComponent {
  constructor(protected _service: ServicesService){}
  
  public name = "";

  ngOnInit(){
    this._service.getNameFromStore()
    .subscribe(res => {
      let nameFromToken = this._service.getNameFromToken();
      this.name = res || nameFromToken
    })
  }
}
