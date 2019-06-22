import { Component, OnInit } from '@angular/core';
import { StudyProgramService } from '../studyPrograms/study-program.service';
import { CenterService } from '../centers/center.service';
import { Router } from '@angular/router';
import { CourseService } from '../courses/course.service';
import Course from '../courses/Course';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-course-material-page',
  templateUrl: './course-material-page.component.html',
  styleUrls: ['./course-material-page.component.css']
})
export class CourseMaterialPageComponent implements OnInit {
  
  title: string;
  pic: Int8Array = new Int8Array();
  mimetype: string;

  constructor(private sanitizer: DomSanitizer, private courseS: CourseService, private router: Router) { }

  ngOnInit() {
    this.courseS.getCourseById(Number(localStorage.getItem('idCourse'))).subscribe((data: Course) => {
      this.title = data.title;
      this.pic = data.pic;
      this.mimetype = data.mimetype;
    });
    

  }

  transform(img: Int8Array, mimetype: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl('data:' + mimetype + ';base64, ' + img.toString());
  }

}
