import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import Subforum from '../subforum/subforum';
import Topic from './topic';
import Message from '../message/message';


@Injectable({
  providedIn: 'root'
})
export class TopicService {

  uri = 'http://localhost:3000/topics';
  reloadData: any;

  messages: Message[] = [];

  constructor(private http: HttpClient) { }

  addTopic(id, name, creationDate, creator, subforum) {
    const obj = {
      id: id,
      name: name,
      subforum: subforum,
      messages: this.messages,
      creationDate: creationDate,
      creator: creator

    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getTopics() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getTopic(id:number) {
    return this
           .http
           .get(`${this.uri}/${id}`);
  }

  

    deleteTopic(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    
}
