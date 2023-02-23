import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { User } from './user';
import { Admin } from './admin';
import { Question } from './question';

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

  public adminLogin(admin:Admin):Observable<any>{
    return this._http.post<any>("",admin)
  }

  public adminRegister(admin:Admin):Observable<any>{
    return this._http.post<any>("",admin)
  }

  public questionCreate(question:Question):Observable<any>{
    return this._http.post<any>("",question)
  }

  public questionSearch(question:Question):Observable<any>{
    return this._http.post<any>("",question)
  }

}
