import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TopicService } from '../../topic/topic-service.service';
import { MessageService } from "../message-service.service";
import { Router } from '@angular/router';
import Topic from 'src/app/forum/forum';

@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.css']
})
export class CreateMessageComponent implements OnInit {

  angForm: FormGroup;
  topics: Topic[];
  selectedTopicId: number = 1;
  constructor(private fb: FormBuilder, private fs: TopicService, private sfs: MessageService, private router: Router) {
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
    this.fs.getTopics()
    .subscribe((data: Topic[]) => {
      this.topics = data;
    });
  }
   addMessage(id, name, creationDate, creator) {
    this.sfs.addMessage(id, name, creationDate, creator, this.fs.getTopic(this.selectedTopicId));
    alert('You have succesfully registered a new forum');
  }

  setTopic($event){
    this.selectedTopicId = $event;
    console.log(this.selectedTopicId);
  }
}

