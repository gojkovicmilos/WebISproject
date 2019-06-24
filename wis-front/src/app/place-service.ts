import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PlaceService {

  uri = 'http://localhost:8080/place';
  reloadData: any;


  constructor(private http: HttpClient) { }



getPlaces() {
  return this
    .http
    .get(`${this.uri}`);
}

getPlaceById(id) {
  return this
    .http
    .get(`${this.uri}/${id}`);
}

}

