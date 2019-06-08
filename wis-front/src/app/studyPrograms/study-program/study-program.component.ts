import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import YearOfStudy from '../../YearOfStudy';
import { StudyProgramService } from '../study-program.service';
import { DataService } from '../../data.service';
import StudyProgram from '../StudyProgram';

@Component({
  selector: 'app-study-program',
  templateUrl: './study-program.component.html',
  styleUrls: ['./study-program.component.css']
})
export class StudyProgramComponent implements OnInit {

  yearOfStudies: YearOfStudy[];
  cssId: string[] = ["lvl1a", "lvl1ab", "lvl1abc", "lvl1abcd"];
  idStudyProgram: number;
  name: string;
  img_src: string;
  nameOfCenter: string;

  constructor(private dataService: DataService ,private router: Router, private spc: StudyProgramService) {
    
   }

  ngOnInit() {
    this.idStudyProgram = Number(localStorage.getItem('idStudijskogPrograma'));
    this.spc.getStudyProgramById(this.idStudyProgram).subscribe((data: StudyProgram) => {
      this.yearOfStudies = data.yearsOfStudy;
      this.name = data.name;
    });
    this.nameOfCenter = localStorage.getItem("imeCentra");
  }




 

}
