import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Topic from '../topic';
import {TopicService} from '../topic-service.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-get-topics',
  templateUrl: './get-topics.component.html',
  styleUrls: ['./get-topics.component.css']
})

export class GetTopicsComponent implements OnInit {

  topics: Topic[];
  constructor(private topicService: TopicService,private router: Router, private sanitizer:DomSanitizer) {
 
   }

  ngOnInit() {
    this.topicService.getTopics()
    .subscribe((data: Topic[]) => {
      this.topics = data;
    });
  }

  

  ngOnDestroy() {
    
  }

  
}


