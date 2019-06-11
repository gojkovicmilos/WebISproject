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

  admin: Admin[];
  
  constructor(private as: AdminService, private router: Router) { }

  ngOnInit() {
    this.as
      .getAdmin()
      .subscribe((data: Admin[]) => {
        this.admin = data;
    });

    
  }

}
