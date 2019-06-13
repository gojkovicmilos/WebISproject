import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ForumService } from '../forum-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-forum',
  templateUrl: './create-forum.component.html',
  styleUrls: ['./create-forum.component.css']
})
export class CreateForumComponent implements OnInit {

  angForm: FormGroup;
  constructor(private fb: FormBuilder, private fs: ForumService, private router: Router) {
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
  }
   addForum(id, name, creationDate, creator) {
    this.fs.addForum(id, name, creationDate, creator);
    alert('You have succesfully registered a new forum');
  }

}

