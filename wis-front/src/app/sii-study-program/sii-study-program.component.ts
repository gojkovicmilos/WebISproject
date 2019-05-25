import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import YearOfStudy from '../YearOfStudy';
import { StudyProgramService } from '../study-program.service';
import { DataService } from '../data.service';
import StudyProgram from '../StudyProgram';

@Component({
  selector: 'app-sii-study-program',
  templateUrl: './sii-study-program.component.html',
  styleUrls: ['./sii-study-program.component.css']
})
export class SiiStudyProgramComponent implements OnInit {

  yearOfStudies: YearOfStudy[];
  cssId: string[] = ["lvl1a", "lvl1ab", "lvl1abc", "lvl1abcd"];
  message: number;

  constructor(private dataService: DataService ,private router: Router, private spc: StudyProgramService) { }

  ngOnInit() {
    this.message = this.dataService.id;
    console.log("NJNJNJNJ"+this.message);
    this.spc.getStudyProgramById(this.message).subscribe((data: StudyProgram) => {
      this.yearOfStudies = data.yearsOfStudy;
    });
    console.log(this.yearOfStudies);
  }




 

}
