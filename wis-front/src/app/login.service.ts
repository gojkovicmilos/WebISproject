import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';


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
  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    let user = {"username": username, "password": password}
    this.http.post<LoginRes>(`${this.uri}`, user).subscribe(res => {
      console.log(res.token);
      this.authToken = res.token;
    });
    this.httpOptions = {headers: new HttpHeaders({
      //'Content-Type':  'application/json',
      'auth-token': this.authToken
    })
  };
  console.log(this.httpOptions)
  }  
  test()
  {
    this.http.get<string>(`http://localhost:8080/test`, this.httpOptions)
    .subscribe(res=>{
      console.log(res);
    }), err=>console.log('error', err)
  }

    
}
  

