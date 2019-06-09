import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  angForm: FormGroup;
  role: string;

  showAdminFields:boolean = false;
  showStudentFields:boolean = false;
  showTeacherFields:boolean = false;


  constructor(private fb: FormBuilder, private rs: RegistrationService, private router: Router) { 
    this.createForm();
  }

  ngOnInit() {
  }

  createForm() {
    this.angForm = this.fb.group({
      username: ['', Validators.required ],
      pass: ['', Validators.required]
    });
  }

  setStudentRole() {
    this.showStudentFields = true;
    this.showTeacherFields = false;
    this.showAdminFields = false;
  }

  setTeacherRole() {
    this.showTeacherFields = true;
    this.showAdminFields = false;
    this.showStudentFields = false;
  }

  setAdminRole() {
    this.showAdminFields = true;
    this.showTeacherFields = false;
    this.showStudentFields = false;
  }

  register(username: string, password: string) {
    this.rs.register(username, password, this.role);
    this.router.navigate(['/']);
  }

}
