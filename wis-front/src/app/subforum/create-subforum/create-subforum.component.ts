import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ForumService } from '../../forum/forum-service.service';
import { SubforumService } from "../subforum-service.service";
import { Router } from '@angular/router';
import Forum from 'src/app/forum/forum';

@Component({
  selector: 'app-create-subforum',
  templateUrl: './create-subforum.component.html',
  styleUrls: ['./create-subforum.component.css']
})
export class CreateSubforumComponent implements OnInit {

  angForm: FormGroup;
  forums: Forum[];
  selectedForumId: number = 1;
  constructor(private fb: FormBuilder, private fs: ForumService, private sfs: SubforumService, private router: Router) {
    this.createForm();
   }

  createForm() {
    this.angForm = this.fb.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      creationDate: ['', Validators.required],
      creator: ['', Validators.required],
    });
  }
  ngOnInit() {
    this.fs.getForums()
    .subscribe((data: Forum[]) => {
      this.forums = data;
    });
  }
   addSubforum(id, name, creationDate, creator) {
    this.sfs.addSubforum(id, name, creationDate, creator, this.fs.getForum(this.selectedForumId));
    alert('You have succesfully registered a new forum');
  }

  setForum($event){
    this.selectedForumId = $event;
    console.log(this.selectedForumId);
  }
}

