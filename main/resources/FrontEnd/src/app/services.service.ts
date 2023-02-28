import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { User } from './user';
import { Admin } from './admin';
import { Question } from './question';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs'
import { JwtHelperService } from '@auth0/angular-jwt'
import { environment } from 'src/environments/environment';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private Url=environment.Url;

  private requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );

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
    return !!localStorage.getItem('jwtToken');
  }

  public getToken(){
    return localStorage.getItem('jwtToken')
  }

  public logout(){
    localStorage.removeItem('jwtToken')
    this._router.navigate(['/loginsignupuser'])
  }

  public userLogin(user:User):Observable<any>{
    return this._http.post<any>(this.Url+"getLogin",user, {headers: this.requestHeader})
  }

  public userRegister(user:User):Observable<any>{
    return this._http.post<any>(this.Url+"adduser",user, {headers: this.requestHeader})
  }

  public adminLogin(admin:Admin):Observable<any>{
    return this._http.post<any>(this.Url+"getLogin",admin, {headers: this.requestHeader})
  }

  public adminRegister(admin:Admin):Observable<any>{
    return this._http.post<any>(this.Url+"addadmin",admin)
  }

  public questionCreate(question:Question):Observable<any>{
    return this._http.post<any>(this.Url+"addquestion",question)
  }

  public allQuestions():Observable<any>{
    return this._http.get(this.Url+"getallquestion");
  }
  public questionSearch(question:Question):Observable<any>{
    return this._http.post<any>(this.Url+"searchquestion",question)
  }

  public pendingQuestion():Observable<any>{
    return this._http.get(this.Url+"getpendingquestions");
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

  public chatUsers():Observable<any>{
    return this._http.get(this.Url+"getallusers");
  }

  public detailQuestion():Observable<any>{
    return this._http.get("")
  }
}
