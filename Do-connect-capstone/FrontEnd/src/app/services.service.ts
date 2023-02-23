import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { User } from './user';
import { Admin } from './admin';
import { Question } from './question';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs'
import { JwtHelperService } from '@auth0/angular-jwt'

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private userpayload:any;
  constructor(private _http: HttpClient, private _router: Router) { 
    this.userpayload = this.decodeToken();
  }

  public name$ = new BehaviorSubject<string>("")

  public getNameFromStore(){
    return this.name$.asObservable();
  }

  public setFullNameForStore(name:string){
    this.name$.next(name)
  }

  public getNameFromToken(){
    if(this.userpayload){
      return this.userpayload.name;
    }
  }

  public decodeToken(){
    const jwtHelper = new JwtHelperService();
    const token = this.getToken()!;
    return jwtHelper.decodeToken(token);
  }
  public isLoggedIn(){
    return !!localStorage.getItem('token');
  }

  public getToken(){
    return localStorage.getItem('token')
  }

  public logout(){
    localStorage.removeItem('token')
    this._router.navigate(['/loginsignupuser'])
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

  public pendingQuestion():Observable<any>{
    return this._http.get("");
  }

  public questionDelete(deleteId):Observable<any>{
    return this._http.delete("",deleteId);
  }

  public questionUpdate(updateId):Observable<any>{
    return this._http.put("",updateId)
  }
  public pendingAnswer():Observable<any>{
    return this._http.get("");
  }
  public answerDelete(deleteId):Observable<any>{
    return this._http.delete("",deleteId);
  }

  public answerUpdate(updateId):Observable<any>{
    return this._http.put("",updateId)
  }

}
