import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-edit-teacher',
  templateUrl: './edit-teacher.component.html',
  styleUrls: ['./edit-teacher.component.css']
})
export class EditTeacherComponent implements OnInit {

  teacher: any = {};
  angForm: FormGroup;

  constructor(private route: ActivatedRoute, 
              private router: Router,
              private ts: TeacherService,
              private fb: FormBuilder) {
                this.createForm();
               }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ts.editTeacher(params.id).subscribe(res => {
        this.teacher = res;
    });
  });
  }

  createForm() {
    this.angForm = this.fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      personalIdentificationNumber: ['', Validators.required ]
    });
  }


  updateTeacher(firstName, lastName, personalIdentificationNumber) {
    this.route.params.subscribe(params => {
       this.ts.updateTeacher(firstName, lastName, personalIdentificationNumber, params.id);
       this.router.navigate(['teacher']);
 });
  }

}
