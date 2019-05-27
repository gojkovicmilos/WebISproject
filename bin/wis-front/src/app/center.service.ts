import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CenterService {
  uri = 'http://localhost:8080/center';
  reloadData: any;

  constructor(private http: HttpClient) { }

  getCenter() {
    return this.http.get(`${this.uri}`);
  }

  getCenterById(id: number) {
    return this.http.get(`${this.uri}/${id}`);
  }
}
