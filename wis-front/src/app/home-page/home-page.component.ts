import { Component, OnInit } from '@angular/core';
import Center from '../Center';
import { CenterService } from '../center.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  centers: Center[];

  constructor(private router: Router, private cs: CenterService) { }

  ngOnInit() {
    
  }

}
