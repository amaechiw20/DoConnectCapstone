import { Component } from '@angular/core';
import { Admin } from '../admin';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css'],
})
export class AdminDashboardComponent {
  admin = new Admin();
  msgRS = '';
  msgRF = '';
  constructor(private _service: ServicesService, private _router: Router) {}

  ngOnInit() {}
  registerAdmin() {
    this._service.adminRegister(this.admin).subscribe(
      (data) => {
        console.log('response recieved');
        this.msgRS = 'Admin registered succesfully!';
      },
      (error) => {
        console.log('exception occurred');
        this.msgRF = 'Registration Failed, please try again!';
      }
    );
  }
}
