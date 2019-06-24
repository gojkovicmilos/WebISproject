import { Component, OnInit } from '@angular/core';
import { StudyProgramService } from '../../studyPrograms/study-program.service';
import { Router } from '@angular/router';
import StudyProgram from '../../studyPrograms/StudyProgram';
import { DataService } from '../../data.service';
import Center from '../Center';
import { CenterService } from '../center.service';
import { DomSanitizer } from '@angular/platform-browser';
import Country from 'src/app/Country';
import { Place } from 'src/app/place';
import { CountryService } from 'src/app/country-service';
import { PlaceService } from 'src/app/place-service';

@Component({
  selector: 'app-center',
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.css']
})
export class CenterComponent implements OnInit {

  center: Center;
  name: string;
  studyPrograms: StudyProgram[];
  country: Country;
  places: Place[];

  // tslint:disable-next-line: max-line-length
  constructor(private cos:CountryService, private ps:PlaceService,private dataService: DataService, private sps: StudyProgramService, private sanitizer: DomSanitizer, private cnt: CenterService, private router: Router) { }

  ngOnInit() {
    this.cnt.getCenterById(Number(localStorage.getItem('idCentra')))
      .subscribe((data: Center) => {
        this.center = data;
        this.studyPrograms = data.studyPrograms;
        this.name = data.name;
      });
      this.cos.getCountryById(Number(localStorage.getItem('idCountry')))
      .subscribe((data : Country)=> {
        this.country = data;
        this.places = data.place;
   
        this.name=data.name;
      });

      this.ps.getPlaceById(Number(localStorage.getItem('idPlace')))
      .subscribe((data : Place)=> {
        this.places = Places.data;
        this.name = data.name;
   
     
      });

  }

  punjenje(id: number) {
    this.dataService.idStudyProgram = id;
    localStorage.setItem('idStudijskogPrograma', this.dataService.idStudyProgram.toString());
    localStorage.setItem('imeCentra', this.name);
  }

  transform(img: Int8Array, mimetype: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl('data:' + mimetype + ';base64, ' + img.toString());
  }
}
