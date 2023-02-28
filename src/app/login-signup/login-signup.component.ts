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
    
  }

  loginUser(){
    this._service.userLogin(this.user1).subscribe(
      data => {
        console.log("response recieved")
        localStorage.setItem('jwtToken', data.jwtToken);
        this._router.navigate(["/userdashboard"])
      },
      error => {
        console.log("exception occurred")
        this.msg = "Bad creentials, Enter valid credentials!"
      }
    )
  }

  registerUser(){
    this._service.userRegister(this.user).subscribe(
      data => {
        console.log("response recieved")
        this.msgRS="User registered succesfully! Login Now!"
      },
      error => {
        console.log("exception occurred")
        console.log(error)
        this.msgRF = "Registration Failed, please try again!"
      }
    )
  }
}
