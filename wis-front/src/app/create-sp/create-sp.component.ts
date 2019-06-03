import { Component, OnInit } from '@angular/core';
import Center from '../Center';
import StudyProgram from '../StudyProgram';
import { CenterService } from '../center.service';
import { StudyProgramService } from '../study-program.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-sp',
  templateUrl: './create-sp.component.html',
  styleUrls: ['./create-sp.component.css']
})
export class CreateSpComponent implements OnInit {

  center: Center[];
  studyProgram: StudyProgram = new StudyProgram();
  angForm: any;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  constructor(private cs: CenterService, private sps: StudyProgramService, private router: Router,  private fb: FormBuilder) { }

  ngOnInit() {
    this.createForm();
    this.sps.getAllCenters().subscribe(
      data => {
        this.center = data.map(item =>{
            return{
              id: item.id,
              name: item.name,
              studyPrograms: item.studyPrograms,
              pic: item.pic,
              mimetype: item.mimetype
            };
        });
      });
}

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  setCenter($event){
    this.angForm.get('center').setValue($event.center.name);
    this.angForm.center.id = $event.id;
    console.log($event);
  }

  createForm() {
    this.angForm = this.fb.group({
      name: ['', Validators.required ]
    });
  }

  upload(name: string, selectedCenter: any) {
    this.progress.percentage = 0;
    this.angForm.center.id = selectedCenter;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.sps.pushFileToStorage(this.currentFileUpload, name, selectedCenter).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });
    this.selectedFiles = undefined;
    this.router.navigate(['/']);
  }

}
