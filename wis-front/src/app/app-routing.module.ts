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
import { WebsocketComponent } from './websocket/websocket.component';
import { CreateYearOfStudyComponent } from './yearOfstudy/create-year-of-study/create-year-of-study.component';
import { CreateCourseComponent } from './courses/create-course/create-course.component';
import { CourseMaterialPageComponent } from './course-material-page/course-material-page.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { DragAndDropComponent } from './drag-and-drop/drag-and-drop.component';

const routes: Routes = [
  {path: 'adminDashBoard/student/add', component: AddStudentComponent},
  {path: 'adminDashBoard/students', component: GetStudentComponent},
  {path: 'adminDashBoard/students/:id', component: EditStudentComponent},
  {path: 'adminDashBoard/findStudentByFirstName', component: SearchStudentComponent},
  {path: 'login', component: LoginComponent},
  {path: 'adminDashBoard/teacher/add', component: AddTeacherComponent},
  {path: 'adminDashBoard/teacher/:id', component: EditTeacherComponent},
  {path: 'adminDashBoard/teacher', component: GetTeacherComponent},
  {path: 'adminDashBoard/findTeacherByFirstName', component: SearchTeacherComponent },
  {path: '', component: HomePageComponent},
  {path: 'center', component: CenterComponent},
  {path: 'center/studyPrograms', component: StudyProgramComponent},
  {path: 'adminDashBoard/createCenter', component: CreateCenterComponent},
  {path: 'adminDashBoard/createSp', component: CreateSpComponent},
  {path: 'adminDashBoard/register', component: RegisterComponent},
  {path: 'chat', component: WebsocketComponent},
  {path: 'adminDashBoard/createYos', component: CreateYearOfStudyComponent},
  {path: 'adminDashBoard/createCourse', component: CreateCourseComponent},
  {path: 'courseMaterialPage', component: CourseMaterialPageComponent},
  {path: 'adminDashBoard', component: AdminDashboardComponent},
  {path: 'dragAndDrop', component: DragAndDropComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: "reload"})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
