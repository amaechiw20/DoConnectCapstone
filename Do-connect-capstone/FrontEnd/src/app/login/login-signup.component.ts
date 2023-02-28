import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router';
import { ServicesService } from '../services.service';
import { User } from '../user';
@Component({
  selector: 'app-login-signup',
  templateUrl: './login-signup.component.html',
  styleUrls: ['./login-signup.component.css']
})
export class LoginSignupComponent implements OnInit {
  
  user = new User();
  user1 = new User();
  response:any;
  msg=''
  msgRS=''
  msgRF=''
  constructor(private _service:ServicesService, private _router: Router){

  }

  ngOnInit(){
    // this._service.user=this.loginUser();
  }

  loginUser(){
    this._service.userLogin(this.user1).subscribe(
      data => {
        console.log("response recieved")
        localStorage.setItem('jwtToken', data.jwtToken);
        this._router.navigate(["/userdashboard"])
        this.response = data;
      },
      error => {
        console.log("exception occurred")
        this.msg = "Bad creentials, Enter valid credentials!"
      }
    )
  }
}
