import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  uri = 'http://localhost:8080/register';

  constructor(private http: HttpClient) { }

  register(username: string, password: string, role: string) {
    let userForRegistration = {"username": username, "password": password, "role": role};
    this.http.post(`${this.uri}`, userForRegistration).subscribe(res => {
      console.log(res);
    })
  }
}
