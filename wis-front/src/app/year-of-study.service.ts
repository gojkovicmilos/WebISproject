import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class YearOfStudyService {
  uri = "http://localhost:8080/yearofstudy";

  constructor(private http: HttpClient) { }

  getYearOfStudy() {
    return this.http.get(`${this.uri}`);
  }

  
}
