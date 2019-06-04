import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  show:boolean = false;
  ngOnInit() {

    if(localStorage.getItem("role") == "admin")
    this.show = true;


  }

}
