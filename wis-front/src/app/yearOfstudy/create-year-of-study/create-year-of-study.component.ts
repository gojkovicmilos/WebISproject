import { Component, OnInit } from '@angular/core';
import StudyProgram from 'src/app/studyPrograms/StudyProgram';
import YearOfStudy from '../YearOfStudy';
import { YosService } from '../yos-service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-year-of-study',
  templateUrl: './create-year-of-study.component.html',
  styleUrls: ['./create-year-of-study.component.css']
})
export class CreateYearOfStudyComponent implements OnInit {

  studyProgram: StudyProgram[];
  angForm: any;
  yearOfstudy: YearOfStudy = new YearOfStudy();
  selectedStudyProgramId: number = 1;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  constructor(private yos: YosService, private router: Router,  private fb: FormBuilder) { }

  ngOnInit() {
    this.createForm();
    this.yos.getAllStudyProgram().subscribe(
      data => {
        this.studyProgram = data.map(item =>{
            return{
              id: item.id,
              name: item.name,
              center: item.center,
              pic: item.pic,
              mimetype: item.mimetype,
              yearsOfStudy: item.yearsOfStudy
            };
        });
      });
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  setStudyProgram($event){
    this.selectedStudyProgramId = $event;
    console.log(this.selectedStudyProgramId);
  }

  createForm() {
    this.angForm = this.fb.group({
      title: ['', Validators.required ]
    });
  }

  upload(title: string) {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.yos.pushFileToStorage(this.currentFileUpload, title, this.selectedStudyProgramId).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });
    this.selectedFiles = undefined;
    setTimeout(() => {
      this.router.navigateByUrl('/', { skipLocationChange: false }).then(() => {
        window.location.reload();
      });
    }, 2000);
  }
}
