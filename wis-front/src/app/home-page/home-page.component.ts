import { Component, OnInit, OnDestroy } from '@angular/core';
import Center from '../Center';
import { CenterService } from '../center.service';
import { Router } from '@angular/router';
import { DataService } from '../data.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  centers: Center[];
  messageForCenterComponent: number;

  constructor(private dataService: DataService,private router: Router, private cnt: CenterService) { }

  ngOnInit() {
    this.cnt.getCenter()
    .subscribe((data: Center[]) => {
      this.centers = data;
    });
  }

  punjenje(id): void {
    this.dataService.idCenter = id;
    localStorage.setItem("idCentra", this.dataService.idCenter.toString());
  }

  ngOnDestroy() {
    
  }
}
