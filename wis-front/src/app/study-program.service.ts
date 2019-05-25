import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudyProgramService {

  uri = 'http://localhost:8080/studyprogram';
  reloadData: any;

  constructor(private http: HttpClient) { }

  getStudyProgram() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getStudyProgramByName(name: string): Observable<any> {
    return this.http.get(`${this.uri}/name/${name}`);
  }

  getStudyProgramById(id: number) {
    return this.http.get(`${this.uri}/${id}`)
  }
}