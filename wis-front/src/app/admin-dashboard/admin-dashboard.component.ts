import { Component, OnInit } from '@angular/core';
import { AdminService } from './admin-service';
import { Router } from '@angular/router';
import Admin from './Admin';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  //admin: Admin;
  username: string;
  firstname: string;
  lastname: string;
  note: string;
  
  constructor(private as: AdminService, private router: Router) { }

  ngOnInit() {
    this.as
      .getAdmin()
      .subscribe((data: Admin[]) => {
        for(var i = 0; i < data.length; i++) {
          if(localStorage.getItem("username") == data[i].user.username) {
            //this.admin = data[i];
            this.username = data[i].user.username;
            this.firstname = data[i].firstName;
            this.lastname = data[i].lastName;
            this.note = data[i].note;
          }
        }
    });

    
  }

}
