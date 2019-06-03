import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


class LoginRes{
  token:string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  uri = 'http://localhost:8080/login';

  authToken = null;

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    let user = {"username": username, "password": password}
    this.http.post<LoginRes>(`${this.uri}`, user).subscribe(res => {
      console.log(res.token);
      this.authToken = res.token;
    })
  }
}
