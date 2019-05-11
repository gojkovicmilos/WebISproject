import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  uri = 'http://localhost:8080/student';
  reloadData: any;

  constructor(private http: HttpClient) { }

  addStudent(firstName, lastName, cardNumber) {
    const obj = {
      firstName: firstName,
      lastName: lastName,
      cardNumber: cardNumber
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

  editStudent(id) {
    return this
            .http
            .get(`${this.uri}/${id}`);
    }

    updateStudent(firstName, lastName, cardNumber, id) {

      const obj = {
          firstName: firstName,
          lastName: lastName,
          cardNumber: cardNumber
        };
      this
        .http
        .put(`${this.uri}/update/${id}`, obj)
        .subscribe(res => console.log('Done'));
    }

    deleteStudent(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }
}
