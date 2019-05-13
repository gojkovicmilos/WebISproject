import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  angForm: FormGroup;
  constructor(private fb: FormBuilder,private ss: StudentService) {
    this.createForm();
  }

  createForm() {
    this.angForm = this.fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      cardNumber: ['', Validators.required ],
      jmbg: ['', Validators.required],
      pass: ['', Validators.required]
    });
  }

  addStudent(firstName, lastName, cardNumber, jmbg, pass) {
    this.ss.addStudent(firstName, lastName, cardNumber, jmbg, pass);
  }
  ngOnInit() {
  }
}
