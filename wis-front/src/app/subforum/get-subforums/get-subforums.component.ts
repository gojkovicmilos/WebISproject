import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Subforum from '../subforum';
import {SubforumService} from '../subforum-service.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-get-subforums',
  templateUrl: './get-subforums.component.html',
  styleUrls: ['./get-subforums.component.css']
})

export class GetSubforumsComponent implements OnInit {

  subforums: Subforum[];
  constructor(private subforumService: SubforumService,private router: Router, private sanitizer:DomSanitizer) {
 
   }

  ngOnInit() {
    this.subforumService.getSubforums()
    .subscribe((data: Subforum[]) => {
      this.subforums = data;
    });
  }

  

  ngOnDestroy() {
    
  }

  
}


