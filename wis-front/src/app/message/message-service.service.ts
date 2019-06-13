import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import Subforum from '../subforum/subforum';
import Topic from '../topic/topic';


@Injectable({
  providedIn: 'root'
})
export class MessageService {

  uri = 'http://localhost:3000/subforums';
  reloadData: any;


  constructor(private http: HttpClient) { }

  addMessage(id, name, creationDate, creator, topic) {
    const obj = {
      id: id,
      name: name,
      topic: topic,
      creationDate: creationDate,
      creator: creator

    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getMessages() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getMessage(id:number) {
    return this
           .http
           .get(`${this.uri}/${id}`);
  }

  

    deleteMessage(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    
}
