import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import Subforum from './subforum';
import Topic from '../topic/topic';


@Injectable({
  providedIn: 'root'
})
export class SubforumService {

  uri = 'http://localhost:3000/subforums';
  reloadData: any;

  topics: Topic[] = [];

  constructor(private http: HttpClient) { }

  addSubforum(id, name, creationDate, creator, forum) {
    const obj = {
      id: id,
      name: name,
      forum: forum,
      topics: this.topics,
      creationDate: creationDate,
      creator: creator

    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getSubforums() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getSubforum(id:number) {
    return this
           .http
           .get(`${this.uri}/${id}`);
  }

  

    deleteSubforum(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    
}
