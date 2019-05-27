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

  // center: Center;
  // yearOfStudies: YearOfStudy[];
  // studyPrograms: StudyProgram[];
  messageForCourseComponent: number;
  centers: Center[];
  // messageForCenterComponent: number;
  // message: number;
  // name: string;

  constructor(private dataService: DataService, private sps: StudyProgramService, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    // this.cnt.getCenterById(this.dataService.idCenter)
    // .subscribe((data: Center) => {
    //   this.center = data;
    //   this.studyPrograms = this.center.studyPrograms;
    // });
    this.cnt.getCenter()
    .subscribe((data: Center[]) => {
      this.centers = data;
      
    });
    // this.message = this.dataService.idStudyProgram;
    // this.sps.getStudyProgramById(this.message).subscribe((data: StudyProgram) => {
    //   this.yearOfStudies = data.yearsOfStudy;
    //   this.name = data.name;
    // });
    // this.sps.getStudyProgram()
    // .subscribe((data: StudyProgram[]) => {
    //   this.studyPrograms = data;
    // });
  }

  punjenje(id): void {
    this.messageForCourseComponent = id;
  }

  ngOnDestroy() {
    this.dataService.idCourse1 = this.messageForCourseComponent;
  }
}
