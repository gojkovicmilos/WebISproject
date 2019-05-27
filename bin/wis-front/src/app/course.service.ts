import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  uri = "http://localhost:8080/course";

  constructor(private http: HttpClient) { }

  getCourse() {
    this.http.get(`${this.uri}`);
  }
}
