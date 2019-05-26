import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddStudentComponent} from './add-student/add-student.component';
import { GetStudentComponent } from './get-student/get-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { SearchStudentComponent } from './search-student/search-student.component';
import {GetTeacherComponent} from './get-teacher/get-teacher.component';
import {EditTeacherComponent} from './edit-teacher/edit-teacher.component';
import {SearchTeacherComponent} from './search-teacher/search-teacher.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { LoginStudentComponent } from './login-student/login-student.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CenterNoviSadComponent } from './center-novi-sad/center-novi-sad.component';
import { StudyProgramComponent } from './study-program/study-program.component';

const routes: Routes = [
  {path: 'student/add', component: AddStudentComponent},
  {path: 'students', component: GetStudentComponent},
  {path: 'students/:id', component: EditStudentComponent},
  {path: 'findStudentByFirstName', component: SearchStudentComponent},
  {path: 'student/login', component: LoginStudentComponent},
  {path: 'teacher/add', component: AddTeacherComponent},
  {path: 'teacher/:id', component: EditTeacherComponent},
  {path: 'teacher', component: GetTeacherComponent},
  {path: 'findTeacherByFirstName', component: SearchTeacherComponent },
  {path: '', component: HomePageComponent},
  {path: 'center', component: CenterNoviSadComponent},
  {path: 'center/studyPrograms', component: StudyProgramComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
