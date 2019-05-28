import { Component, OnInit } from '@angular/core';
import Center from '../Center';
import StudyProgram from '../StudyProgram';
import { DataService } from '../data.service';
import { StudyProgramService } from '../study-program.service';
import { CenterService } from '../center.service';
import { Router } from '@angular/router';
import YearOfStudy from '../YearOfStudy';

@Component({
  selector: 'app-course-page-material',
  templateUrl: './course-page-material.component.html',
  styleUrls: ['./course-page-material.component.css']
})
export class CoursePageMaterialComponent implements OnInit {


  messageForCourseComponent: number;
  centers: Center[];
  cssId: string[] = ['menu1','menu1sub1', 'menu1sub1sub1'];

  

  constructor(private dataService: DataService, private sps: StudyProgramService, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    this.cnt.getCenter()
    .subscribe((data: Center[]) => {
      this.centers = data;
    });
  }

  punjenje(id): void {
    this.messageForCourseComponent = id;
  }

  ngOnDestroy() {
    this.dataService.idCourse1 = this.messageForCourseComponent;
  }
}
