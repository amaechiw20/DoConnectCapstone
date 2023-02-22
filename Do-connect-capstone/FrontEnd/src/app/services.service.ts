import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private _http: HttpClient) { 

  }

  public userLogin(user:User):Observable<any>{
    return this._http.post<any>("",user)
  }

  public userRegister(user:User):Observable<any>{
    return this._http.post<any>("",user)
  }
}
