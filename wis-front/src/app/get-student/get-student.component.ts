import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import { StudentService } from '../student.service';
@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css']
})
export class GetStudentComponent implements OnInit {

  students: Student[];

  constructor(private ss: StudentService) { }

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
    });
  }
}
