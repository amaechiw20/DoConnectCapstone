import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServicesService } from '../services.service';
import { User } from '../user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User();
  user1 = new User();
  response: any;
  msg = '';
  msgRS = '';
  msgRF = '';
  constructor(private _service: ServicesService, private _router: Router) {}

  ngOnInit() {}

  loginUser() {
    this._service.userLogin(this.user1).subscribe(
      (data) => {
        console.log('response recieved');
        localStorage.setItem('jwtToken', data.jwtToken);
        this._router.navigate(['/userdashboard']);
      },
      (error) => {
        console.log('exception occurred');
        this.msg = 'Bad creentials, Enter valid credentials!';
      }
    );
  }
}
