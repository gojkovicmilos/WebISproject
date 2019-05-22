import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { StudentService } from './student.service';
import { GetStudentComponent } from './get-student/get-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { SearchStudentComponent } from './search-student/search-student.component';

import { SearchTeacherComponent } from './search-teacher/search-teacher.component';
import { GetTeacherComponent } from './get-teacher/get-teacher.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { LoginStudentComponent } from './login-student/login-student.component';
import { EditTeacherComponent } from './edit-teacher/edit-teacher.component';
import { FooterComponent } from './footer/footer.component';
import { ModalBasicComponent } from './modal-basic/modal-basic.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomePageComponent } from './home-page/home-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AgmCoreModule } from '@agm/core';


@NgModule({
  declarations: [
    AppComponent,
    AddStudentComponent,
    GetStudentComponent,
    EditStudentComponent,
    SearchStudentComponent,
    SearchTeacherComponent,
    GetTeacherComponent,
    AddTeacherComponent,
    LoginStudentComponent,
    EditTeacherComponent,
    FooterComponent,
    ModalBasicComponent,
    HomePageComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlimLoadingBarModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyB2qilSTZvWZFo1puwcpU3qHH-_bnN8DyQ'
    })
  ],
  providers: [StudentService],
  bootstrap: [AppComponent, ModalBasicComponent],
  exports: [ModalBasicComponent]
})
export class AppModule { }
