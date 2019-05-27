import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  public idStudyProgram: number;
  public idCenter: number;
  public idCourse1: number;
  constructor() { }
}
