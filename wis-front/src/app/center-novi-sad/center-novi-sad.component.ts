import { Component, OnInit, OnDestroy } from '@angular/core';
import { StudyProgramService} from '../study-program.service';
import { Router } from '@angular/router';
import StudyProgram from '../StudyProgram';
import { DataService } from '../data.service';

@Component({
  selector: 'app-center-novi-sad',
  templateUrl: './center-novi-sad.component.html',
  styleUrls: ['./center-novi-sad.component.css']
})
export class CenterNoviSadComponent implements OnInit {

  studyPrograms: StudyProgram[];
  messageForStudyProgram: number;

  constructor(private dataService: DataService, private sps: StudyProgramService, private router: Router) { }

  ngOnInit() {
    this.sps
      .getStudyProgram()
      .subscribe((data: StudyProgram[]) => {
        this.studyPrograms = data;
    });
  }

  punjenje(id: number) {
    this.messageForStudyProgram = id;
  }

  ngOnDestroy() {
    this.dataService.id = this.messageForStudyProgram;
  }

}
