import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Forum from '../forum';
import {ForumService} from '../forum-service.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-get-forums',
  templateUrl: './get-forums.component.html',
  styleUrls: ['./get-forums.component.css']
})

export class GetForumsComponent implements OnInit {

  forums: Forum[];
  constructor(private forumService: ForumService,private router: Router, private sanitizer:DomSanitizer) {
 
   }

  ngOnInit() {
    this.forumService.getForums()
    .subscribe((data: Forum[]) => {
      this.forums = data;
    });
  }

  

  ngOnDestroy() {
    
  }

  
}


