import { Component } from '@angular/core';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-user-navbar',
  templateUrl: './user-navbar.component.html',
  styleUrls: ['./user-navbar.component.css'],
})
export class UserNavbarComponent {
  constructor(protected _service: ServicesService) {}
  public name = '';

  ngOnInit() {
    this._service.getNameFromStore().subscribe((res) => {
      let nameFromToken = this._service.getNameFromToken();
      this.name = res || nameFromToken;
    });
  }
}
