import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  showAdminPanel:boolean = false;
  showLogin:boolean = false;
  ngOnInit() {

    if(localStorage.getItem("role") == "admin")
    this.showAdminPanel = true;

    if(localStorage.getItem("role") == null)
    this.showLogin = true;


  }

  signOut()
  {
    localStorage.clear();
  }

}
