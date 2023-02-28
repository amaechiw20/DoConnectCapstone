import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServicesService } from '../services.service';
import { User } from '../user';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = new User();
  user1 = new User();
  response: any;
  msg = '';
  msgRF = '';
  constructor(private _service: ServicesService, private _router: Router) {}

  ngOnInit() {}

  registerUser() {
    this._service.userRegister(this.user).subscribe(
      (data) => {
        console.log("response recieved")
        localStorage.setItem('jwtToken', data.jwtToken);
        this._router.navigate(['/userdashboard']);
      },
      (error) => {
        console.log('exception occurred');
        this.msgRF = 'Registration Failed, please try again!';
      }
    );
  }
}