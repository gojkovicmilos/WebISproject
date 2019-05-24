import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { YearOfStudyService } from '../year-of-study.service';
import YearOfStudy from '../YearOfStudy';
import Course from '../Course';

@Component({
  selector: 'app-sii-study-program',
  templateUrl: './sii-study-program.component.html',
  styleUrls: ['./sii-study-program.component.css']
})
export class SiiStudyProgramComponent implements OnInit {

  yearOfStudies: YearOfStudy[];
  cssId: string[] = ["lvl1a", "lvl1ab", "lvl1abc", "lvl1abcd"];

  constructor(private router: Router, private yoss: YearOfStudyService) { }

  ngOnInit() {
    this.yoss.getYearOfStudy()
              .subscribe((data: YearOfStudy[]) => {
                this.yearOfStudies = data;
              });
  }



 

}
