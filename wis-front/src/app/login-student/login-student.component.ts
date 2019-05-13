import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login-student',
  templateUrl: './login-student.component.html',
  styleUrls: ['./login-student.component.css']
})
export class LoginStudentComponent implements OnInit {

  angForm: FormGroup;
  constructor(private fb: FormBuilder, private ss: StudentService, private router: Router) {
    this.createForm();
  }

  createForm() {
    this.angForm = this.fb.group({
      cardNumber: ['', Validators.required ],
      pass: ['', Validators.required]
    });
  }

  logInStudent(cardNumber, pass) {
    this.ss.logInStudent( cardNumber, pass);
    this.router.navigate(['students']);
  }
  ngOnInit() {
  }
}
