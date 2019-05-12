import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit {

  angForm: FormGroup;
  constructor(private fb: FormBuilder, private ts: TeacherService) {
    this.createForm();
   }

  createForm() {
    this.angForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      personalIdentificationNumber: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  addTeacher(firstName, lastName, personalIdentificationNumber) {
    this.ts.addTeacher(firstName, lastName, personalIdentificationNumber);
  }

}
