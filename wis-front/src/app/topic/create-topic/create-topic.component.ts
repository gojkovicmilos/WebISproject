import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SubforumService } from '../../subforum/subforum-service.service';
import { TopicService } from "../topic-service.service";
import { Router } from '@angular/router';
import Subforum from 'src/app/forum/forum';

@Component({
  selector: 'app-create-topic',
  templateUrl: './create-topic.component.html',
  styleUrls: ['./create-topic.component.css']
})
export class CreateTopicComponent implements OnInit {

  angForm: FormGroup;
  subforums: Subforum[];
  selectedSubforumId: number = 1;
  constructor(private fb: FormBuilder, private fs: SubforumService, private sfs: TopicService, private router: Router) {
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
    this.fs.getSubforums()
    .subscribe((data: Subforum[]) => {
      this.subforums = data;
    });
  }
   addTopic(id, name, creationDate, creator) {
    this.sfs.addTopic(id, name, creationDate, creator, this.fs.getSubforum(this.selectedSubforumId));
    alert('You have succesfully registered a new forum');
  }

  setSubforum($event){
    this.selectedSubforumId = $event;
    console.log(this.selectedSubforumId);
  }
}

