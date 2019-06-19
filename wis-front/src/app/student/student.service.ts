import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  uri = 'http://localhost:8080/student';
  reloadData: any;
  authKey: string;

  constructor(private http: HttpClient) { }

  addStudent(firstname, lastname, cardnumber, password) {
    const obj = {
      firstName: firstname,
      lastName: lastname,
      cardNumber: cardnumber,
      pass: password
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

    updateStudent(firstname, lastname, cardnumber, password, id) {

      const obj = {
          firstName: firstname,
          lastName: lastname,
          cardNumber: cardnumber,
          pass: password
};
      this
        .http
        .put(`${this.uri}/update/${id}`, obj)
        .subscribe(res => console.log('Done'));
    }

    deleteStudent(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    getStudentByFirstName(firstName: string): Observable<any> {
      return this.http.get(`${this.uri}/firstname/${firstName}`);
    }

    getStudentByLastName(lastName: string): Observable<any> {
      return this.http.get(`${this.uri}/lastname/${lastName}`);
    }

    logInStudent(cardNumber: string, password: string)
    {

      const obj = 
      {
        card: cardNumber,
        pass: password

      };

      this.http.post(`${this.uri}/login`, obj).subscribe(res => console.log('Done'));
    }


    getXML(id) {

      this.authKey = localStorage.getItem('token');
      
      const httpOptions = {
        responseType: 'blob',
        headers: new HttpHeaders({
          'Authorization': this.authKey,
      
        })
      };
      
      return this.http.get(`${this.uri}/downloadxml/${id}`, {responseType: 'blob', headers: new HttpHeaders({
        'Authorization': this.authKey,
    
      }) } );
    }

}
