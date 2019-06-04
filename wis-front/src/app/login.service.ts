import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


class LoginRes{
  token:string;
} 

class TestRes{
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

  login(username: string, password: string, role:string) {
    let user = {"username": username, "password": password}
    this.http.post<LoginRes>(`${this.uri}`, user).subscribe(res => {
      console.log(res.token);
      this.authToken = res.token;
      localStorage.setItem("token", res.token);
      localStorage.setItem("role", role);
    });
  
    
  }  
  test()
  {
    this.http.get<TestRes>(`http://localhost:8080/test`)
    .subscribe(res=>{
      console.log(res[0]);
    }), err=>console.log('error', err)
  }

    
}
  

