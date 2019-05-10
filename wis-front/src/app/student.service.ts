import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  uri = 'http://localhost:8080/student';

  constructor(private http: HttpClient) { }

  addStudent(firstName, lastName, cardNumber) {
    const obj = {
      FirstName: firstName,
      LastName: lastName,
      CardNumber: cardNumber
    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getStudents() {
    return this
           .http
           .get(`${this.uri}`);
  }
}
