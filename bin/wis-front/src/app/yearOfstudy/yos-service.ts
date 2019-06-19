import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import StudyProgram from '../studyPrograms/StudyProgram';

@Injectable({
    providedIn: 'root'
})
export class YosService {
    uri = 'http://localhost:8080/yearofstudy';
    private spUrl = "http://localhost:8080\\studyprogram";
    reloadData: any;

    constructor(private http: HttpClient) { }

    getYearOfStudy() {
        return this
            .http
            .get(`${this.uri}`);
    }

    getYearOfStudyByTitle(title: string): Observable<any> {
        return this.http.get(`${this.uri}/title/${title}`);
    }

    getYearOfStudyById(id: number) {
        return this.http.get(`${this.uri}/${id}`)
    }

    getAllStudyProgram(): Observable<StudyProgram[]> {
        return this.http.get<any[]>(this.spUrl);
    }

    pushFileToStorage(file: File, title: string, selectedStudyProgramId: number): Observable<HttpEvent<{}>> {
        const formdata: FormData = new FormData();

        formdata.append('file', file);
        formdata.append('title', title);
        formdata.append('studyProgram', selectedStudyProgramId.toString());

        const req = new HttpRequest('POST', 'http://localhost:8080/yearofstudy/file/upload', formdata, {
            reportProgress: true,
            responseType: 'text'
        });
        return this.http.request(req);
    }
}