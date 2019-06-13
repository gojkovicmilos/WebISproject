import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Message from '../message';
import {MessageService} from '../message-service.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-get-messages',
  templateUrl: './get-messages.component.html',
  styleUrls: ['./get-messages.component.css']
})

export class GetMessagesComponent implements OnInit {

  messages: Message[];
  constructor(private messageService: MessageService,private router: Router, private sanitizer:DomSanitizer) {
 
   }

  ngOnInit() {
    this.messageService.getMessages()
    .subscribe((data: Message[]) => {
      this.messages = data;
    });
  }

  

  ngOnDestroy() {
    
  }

  
}


