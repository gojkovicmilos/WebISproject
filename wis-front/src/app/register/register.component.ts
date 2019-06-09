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
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  cardnumber: string;

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
      pass: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      cardnumber: [],
      personalid: []
    });
  }

  setStudentRole() {
    this.showStudentFields = true;
    this.showTeacherFields = false;
    this.showAdminFields = false;
    this.role = "ROLE_STUDENT";
  }

  setTeacherRole() {
    this.showTeacherFields = true;
    this.showAdminFields = false;
    this.showStudentFields = false;
    this.role = "ROLE_TEACHER";
  }

  setAdminRole() {
    this.showAdminFields = true;
    this.showTeacherFields = false;
    this.showStudentFields = false;
    this.role = "ROLE_ADMIN";
  }

  register(username: string, password: string) {
    //this.rs.register(username, password, this.role);
    this.router.navigate(['/']);
  }

  registerStudent(username: string, password: string, firstname: string, lastname: string, cardnumber: string)
  {
    this.rs.registerStudent(username, password, this.role, firstname, lastname, cardnumber);
    console.log(this.firstname);
  }

}
