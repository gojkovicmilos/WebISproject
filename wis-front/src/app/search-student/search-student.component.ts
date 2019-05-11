import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-search-student',
  templateUrl: './search-student.component.html',
  styleUrls: ['./search-student.component.css']
})
export class SearchStudentComponent implements OnInit {

  firstName: string;
  students: Student[];

  constructor(private ss: StudentService) { }

  ngOnInit() {
    this.firstName = '';
  }

  private searchStudents() {
    this.ss.getStudentByFirstName(this.firstName)
      .subscribe(students => this.students = students);
      }

  onSubmit() {
    this.searchStudents();
  }

}
