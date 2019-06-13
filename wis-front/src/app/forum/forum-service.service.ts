import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import Subforum from '../subforum/subforum';


@Injectable({
  providedIn: 'root'
})
export class ForumService {

  uri = 'http://localhost:3000/forums';
  reloadData: any;

  subforums: Subforum[] = [];

  constructor(private http: HttpClient) { }

  addForum(id, name, creationDate, creator) {
    const obj = {
      id: id,
      name: name,
      subforums: this.subforums,
      creationDate: creationDate,
      creator: creator

    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getForums() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getForum(id:number) {
    return this
           .http
           .get(`${this.uri}/${id}`);
  }

  

    deleteForum(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    
}
