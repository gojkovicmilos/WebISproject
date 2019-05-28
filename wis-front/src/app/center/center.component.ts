import { Component, OnInit, OnDestroy } from '@angular/core';
import { StudyProgramService} from '../study-program.service';
import { Router } from '@angular/router';
import StudyProgram from '../StudyProgram';
import { DataService } from '../data.service';
import Center from '../Center';
import { CenterService } from '../center.service';

@Component({
  selector: 'app-center',
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.css']
})
export class CenterComponent implements OnInit {

  center: Center;
  studyPrograms: StudyProgram[];
  messageForStudyProgram: number;
  

  constructor(private dataService: DataService, private sps: StudyProgramService, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    //console.log(Number(localStorage.getItem("idCentra")));
    this.cnt.getCenterById(Number(localStorage.getItem("idCentra")))
    .subscribe((data: Center) => {
      this.center = data;
      this.studyPrograms = this.center.studyPrograms;
    });
  }

  punjenje(id: number) {
    this.dataService.idStudyProgram = id;
    localStorage.setItem("idStudijskogPrograma", this.dataService.idStudyProgram.toString());
  }

  ngOnDestroy() {
    
  }

}
