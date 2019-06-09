import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddStudentComponent} from './student/add-student/add-student.component';
import { GetStudentComponent } from './student/get-student/get-student.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { SearchStudentComponent } from './student/search-student/search-student.component';
import {GetTeacherComponent} from './teachers/get-teacher/get-teacher.component';
import {EditTeacherComponent} from './teachers/edit-teacher/edit-teacher.component';
import {SearchTeacherComponent} from './teachers/search-teacher/search-teacher.component';
import { AddTeacherComponent } from './teachers/add-teacher/add-teacher.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CenterComponent } from './centers/center/center.component';
import { StudyProgramComponent } from './studyPrograms/study-program/study-program.component';
import { CreateCenterComponent } from './centers/create-center/create-center.component';
import { CreateSpComponent } from './studyPrograms/create-study-program/create-sp.component';
import { RegisterComponent } from './register/register.component';
import { CreateYearOfStudyComponent } from './yearOfstudy/create-year-of-study/create-year-of-study.component';

const routes: Routes = [
  {path: 'student/add', component: AddStudentComponent},
  {path: 'students', component: GetStudentComponent},
  {path: 'students/:id', component: EditStudentComponent},
  {path: 'findStudentByFirstName', component: SearchStudentComponent},
  {path: 'student/login', component: LoginComponent},
  {path: 'teacher/add', component: AddTeacherComponent},
  {path: 'teacher/:id', component: EditTeacherComponent},
  {path: 'teacher', component: GetTeacherComponent},
  {path: 'findTeacherByFirstName', component: SearchTeacherComponent },
  {path: '', component: HomePageComponent},
  {path: 'center', component: CenterComponent},
  {path: 'center/studyPrograms', component: StudyProgramComponent},
  {path: 'createCenter', component: CreateCenterComponent},
  {path: 'createSp', component: CreateSpComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'createYos', component: CreateYearOfStudyComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: "reload"})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
