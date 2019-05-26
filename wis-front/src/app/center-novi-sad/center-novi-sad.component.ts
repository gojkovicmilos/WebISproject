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

  center: Center;
  studyPrograms: StudyProgram[];
  messageForStudyProgram: number;
  name: string;

  constructor(private dataService: DataService, private sps: StudyProgramService, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    this.cnt.getCenterById(this.dataService.idCenter)
    .subscribe((data: Center) => {
      this.center = data;
      this.name = data.name;
      this.studyPrograms = this.center.studyPrograms;
    });
  }

  punjenje(id: number) {
    this.messageForStudyProgram = id;
  }

  ngOnDestroy() {
    this.dataService.idStudyProgram = this.messageForStudyProgram;
  }

}
