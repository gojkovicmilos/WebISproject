import { Component, OnInit } from '@angular/core';
import { CourseService } from '../course.service';
import { Router } from '@angular/router';
import Course from '../Course';

@Component({
  selector: 'app-center-novi-sad',
  templateUrl: './center-novi-sad.component.html',
  styleUrls: ['./center-novi-sad.component.css']
})
export class CenterNoviSadComponent implements OnInit {

  courses: Course[];

  constructor(private cs: CourseService, private router: Router) { }

  ngOnInit() {
    this.cs
      .getCourse()
      .subscribe((data: Course[]) => {
        this.courses = data;
    });
  }

}
