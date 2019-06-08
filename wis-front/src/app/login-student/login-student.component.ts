import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import {Observable} from 'rxjs'; // Angular 6 
// import {Observable} from 'rxjs/Rx'; // Angular 5

  


@Component({
  selector: 'app-login-student',
  templateUrl: './login-student.component.html',
  styleUrls: ['./login-student.component.css']
})
export class LoginStudentComponent implements OnInit {

  teacherRole:boolean = false;
  studentRole:boolean = false;
  adminRole: boolean = false;
  role: string;

  angForm: FormGroup;
  constructor(private fb: FormBuilder, private ss: StudentService, private router: Router, private ls: LoginService) {
    this.createForm();
    
  }

  createForm() {
    this.angForm = this.fb.group({
      username: ['', Validators.required ],
      pass: ['', Validators.required]
    });
  }

  login(username: string, password: string) {
    this.ls.login(username, password, this.role);
// tslint:disable-next-line: deprecation
    location.reload(true);
    this.router.navigateByUrl('/createCenter', {skipLocationChange: true}).then(() =>
    this.router.navigate(['/']));
  }
  ngOnInit() {
  }

  test()
  {
    this.ls.test();
  }

  setTeacherRole()
  {
    this.role = "teacher";
  }

  setStudentRole()
  {
    this.role = "student";
  }

  setAdminRole()
  {
    this.role = "admin";
  }

  redirectTo(uri) {
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() =>
    this.router.navigate([uri]));
  }

}
