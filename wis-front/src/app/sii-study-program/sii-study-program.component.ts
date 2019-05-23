import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { YearOfStudyService } from '../year-of-study.service';
import YearOfStudy from '../YearOfStudy';

@Component({
  selector: 'app-sii-study-program',
  templateUrl: './sii-study-program.component.html',
  styleUrls: ['./sii-study-program.component.css']
})
export class SiiStudyProgramComponent implements OnInit {

  yearOfStudies: YearOfStudy[] = [];

  constructor(private router: Router, private yoss: YearOfStudyService) { }

  ngOnInit() {
    this.yoss.getYearOfStudy()
              .subscribe((data: YearOfStudy[]) => {
                this.yearOfStudies = data;
              });
  }



 

}
