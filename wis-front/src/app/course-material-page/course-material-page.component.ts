import { Component, OnInit } from '@angular/core';
import { StudyProgramService } from '../studyPrograms/study-program.service';
import { CenterService } from '../centers/center.service';
import { Router } from '@angular/router';
import { CourseService } from '../courses/course.service';
import Course from '../courses/Course';

@Component({
  selector: 'app-course-material-page',
  templateUrl: './course-material-page.component.html',
  styleUrls: ['./course-material-page.component.css']
})
export class CourseMaterialPageComponent implements OnInit {
  
  title: string;


  constructor(private courseS: CourseService, private sps: StudyProgramService, private cs: CenterService, private router: Router) { }

  ngOnInit() {
    this.courseS.getCourseById(Number(localStorage.getItem('idCourse'))).subscribe((data: Course) => {
      this.title = data.title;
    });

  }

}
