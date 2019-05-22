import { Component, OnInit } from '@angular/core';
import Teacher from '../Teacher';
import { TeacherService } from '../teacher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-teacher',
  templateUrl: './get-teacher.component.html',
  styleUrls: ['./get-teacher.component.css']
})
export class GetTeacherComponent implements OnInit {

  teachers: Teacher[];

  constructor(private ts: TeacherService, private router: Router) { }

deleteTeacher(id) {
  this.ts.deleteTeacher(id).subscribe(res => {
    console.log('Deleted');
    this.router.navigate(['teacher']);
    this.ngOnInit();
  });
}

ngOnInit() {
  this.ts
    .getTeachers()
    .subscribe((data: Teacher[]) => {
      this.teachers = data;
});

}
}
