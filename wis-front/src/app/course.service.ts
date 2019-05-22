import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  uri = 'http://localhost:8080/course';
  reloadData: any;

  constructor(private http: HttpClient) { }

  getCourse() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getCourseByTitle(title: string): Observable<any> {
    return this.http.get(`${this.uri}/title/${title}`);
  }
}