import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-login-student',
  templateUrl: './login-student.component.html',
  styleUrls: ['./login-student.component.css']
})
export class LoginStudentComponent implements OnInit {

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
  /*
  logInStudent(cardNumber, pass) {
    this.ss.logInStudent( cardNumber, pass);
    this.router.navigate(['students']);
  }
  */

  login(username: string, password: string) {
    this.ls.login(username, password);
    //this.router.navigate(['/']);
  }
  ngOnInit() {
  }

  test()
  {
    this.ls.test();
  }

}
