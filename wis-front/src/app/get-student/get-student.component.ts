import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { componentRefresh } from '@angular/core/src/render3/instructions';
@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css']
})
export class GetStudentComponent implements OnInit {

  students: Student[];

  constructor(private ss: StudentService, private router: Router) { }

  ngOnInit() {
    
    this.ss
      .getStudents()
      .subscribe((data: Student[]) => {
        this.students = data;
    });
  }

  deleteStudent(id) {
    this.ss.deleteStudent(id).subscribe(res => {
      console.log('Deleted');
      this.router.navigate(['students']);
    });
  }
}
