import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private _service: ServicesService, private _router: Router){}
  
  canActivate(): boolean{
    if(this._service.isLoggedIn()){
      return true;
    } else {
      this._router.navigate(["/loginsignupuser"]);
      return false;
    }
  }  
}
