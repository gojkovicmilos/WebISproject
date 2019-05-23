import { Component, OnInit } from '@angular/core';
import { StudyProgramService} from '../study-program.service';
import { Router } from '@angular/router';
import StudyProgram from '../StudyProgram';

@Component({
  selector: 'app-center-novi-sad',
  templateUrl: './center-novi-sad.component.html',
  styleUrls: ['./center-novi-sad.component.css']
})
export class CenterNoviSadComponent implements OnInit {

  studyPrograms: StudyProgram[];

  constructor(private sps: StudyProgramService, private router: Router) { }

  ngOnInit() {
    this.sps
      .getStudyProgram()
      .subscribe((data: StudyProgram[]) => {
        this.studyPrograms = data;
    });
  }

}
