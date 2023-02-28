import { Component } from '@angular/core';
import { Admin } from '../admin';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  admin = new Admin();
  public response:any;
  msg=''

  constructor(private _service:ServicesService, private _router: Router){

  }

  ngOnInit(){
    
  }

  loginAdmin(){
    this._service.adminLogin(this.admin).subscribe(
      (data:any) => {
        this.response=data;
        localStorage.setItem("jwtToken",data.jwtToken)
        this._router.navigate(["/admindashboard"])
      },
      error => {
        console.log("exception occurred")
        this.msg = "Bad creentials, Enter valid credentials!"
      }
    )
  }
}
