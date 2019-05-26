import { Component, OnInit, OnDestroy } from '@angular/core';
import { StudyProgramService} from '../study-program.service';
import { Router } from '@angular/router';
import StudyProgram from '../StudyProgram';
import { DataService } from '../data.service';
import Center from '../Center';
import { CenterService } from '../center.service';

@Component({
  selector: 'app-center-novi-sad',
  templateUrl: './center-novi-sad.component.html',
  styleUrls: ['./center-novi-sad.component.css']
})
export class CenterNoviSadComponent implements OnInit {

  centers: Center[];
  studyPrograms: StudyProgram[];
  messageForStudyProgram: number;

  constructor(private dataService: DataService, private sps: StudyProgramService, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    this.sps
      .getStudyProgram()
      .subscribe((data: StudyProgram[]) => {
        this.studyPrograms = data;
    });
    this.cnt.getCenter()
    .subscribe((data: Center[]) => {
      this.centers = data;
    });
  }

  punjenje(id: number) {
    this.messageForStudyProgram = id;
  }

  ngOnDestroy() {
    this.dataService.id = this.messageForStudyProgram;
  }

}
