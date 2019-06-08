import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router) {

  }

  showAdminPanel: boolean = false;
  showLogin: boolean = false;
  ngOnInit() {

    if (localStorage.getItem("role") == "admin")
      this.showAdminPanel = true;

    if (localStorage.getItem("role") == null)
      this.showLogin = true;


  }

  signOut() {
    localStorage.clear();
    location.reload(true);
    this.redirectTo('/');

  }

  redirectTo(uri) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([uri]));
  }
}
