import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddStudentComponent} from './add-student/add-student.component';
import { GetStudentComponent } from './get-student/get-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { SearchStudentComponent } from './search-student/search-student.component';
import { LoginStudentComponent } from './login-student/login-student.component';

const routes: Routes = [
  {path: 'student/add', component: AddStudentComponent},
  {path: 'students', component: GetStudentComponent},
  {path: 'students/:id', component: EditStudentComponent},
  {path: 'findStudentByFirstName', component: SearchStudentComponent},
  {path: 'student/login', component: LoginStudentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
