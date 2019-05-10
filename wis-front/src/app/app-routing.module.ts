import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddStudentComponent} from './add-student/add-student.component';
import { GetStudentComponent } from './get-student/get-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';

const routes: Routes = [
  {
    path: 'student/add',
    component: AddStudentComponent
  },
  {
    path: 'students',
    component: GetStudentComponent
  },
  {
    path: 'students/:id',
    component: EditStudentComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
