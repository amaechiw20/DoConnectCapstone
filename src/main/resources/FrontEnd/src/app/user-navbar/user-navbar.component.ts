import { Component } from '@angular/core';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-user-navbar',
  templateUrl: './user-navbar.component.html',
  styleUrls: ['./user-navbar.component.css']
})
export class UserNavbarComponent {
  constructor(protected _service: ServicesService){}
  // public name = this._service.user.name;

  ngOnInit(){
    
  }
}
