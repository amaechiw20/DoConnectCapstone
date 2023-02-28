import { Component } from '@angular/core';
import { User } from '../user';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
 
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