import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MyHttpInterceptor } from './interceptor';


class LoginRes{
  token:string;
} 



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  uri = 'http://localhost:8080/login';

  authToken = null;
  httpOptions = null;
  constructor(private http: HttpClient, private myInterceptor: MyHttpInterceptor) { }

  login(username: string, password: string) {
    let user = {"username": username, "password": password}
    this.http.post<LoginRes>(`${this.uri}`, user).subscribe(res => {
      console.log(res.token);
      this.authToken = res.token;
    });
  
    localStorage.setItem("token", this.authToken);
  }  
  test()
  {
    this.http.get<string>(`http://localhost:8080/test`)
    .subscribe(res=>{
      console.log(res);
    }), err=>console.log('error', err)
  }

    
}
  

