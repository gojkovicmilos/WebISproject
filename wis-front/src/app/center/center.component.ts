import { Component, OnInit } from '@angular/core';
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
  name:string;
  studyPrograms: StudyProgram[];
  

  constructor(private dataService: DataService, private sps: StudyProgramService, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    this.cnt.getCenterById(Number(localStorage.getItem("idCentra")))
    .subscribe((data: Center) => {
      this.center = data;
      this.studyPrograms = this.center.studyPrograms;
      this.name = this.center.name;
    });
  }

  punjenje(id: number) {
    this.dataService.idStudyProgram = id;
    localStorage.setItem("idStudijskogPrograma", this.dataService.idStudyProgram.toString());
  }

  // imgLoad()
  // {
  // var uints = new Uint8Array(this.center.pic);
  // var base64 = btoa(String.fromCharCode.apply(null, uints));
  // this.center. url = 'data:image/jpeg;base64,' + base64;
  // }

}
