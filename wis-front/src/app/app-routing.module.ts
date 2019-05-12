import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddStudentComponent} from './add-student/add-student.component';
import { GetStudentComponent } from './get-student/get-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { SearchStudentComponent } from './search-student/search-student.component';
// import {AddTeacherComponent};
 import{GetTeacherComponent} from './get-teacher/get-teacher.component';
 // import {EditTeacherComponent};
import {SearchTeacherComponent} from './search-teacher/search-teacher.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { EditTeacherComponent } from './edit-teacher/edit-teacher.component';

const routes: Routes = [
  {path: 'student/add', component: AddStudentComponent},
  {path: 'students', component: GetStudentComponent},
  {path: 'students/:id', component: EditStudentComponent},
  {path: 'findByFirstName', component: SearchStudentComponent},
  {path: 'teacher/add', component: AddTeacherComponent},
  {path: 'teachers/:id', component: EditTeacherComponent},


  //{path: 'teacher/add', component: AddTeacherComponent},
  {path: 'teachers', component: GetTeacherComponent},
  //{path: 'teachers/:id', component: EditTeacherComponent},
  {path: 'findByFirstName', component: SearchTeacherComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
