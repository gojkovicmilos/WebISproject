import { Component, OnInit } from '@angular/core';
import Forum from '../forum/forum';
import { ForumService } from '../forum/forum-service.service';

import Subforum from '../subforum/subforum';
import { SubforumService } from '../subforum/subforum-service.service';

import Topic from '../topic/topic';
import { TopicService } from '../topic/topic-service.service';

@Component({
  selector: 'app-search-forum',
  templateUrl: './search-forum.component.html',
  styleUrls: ['./search-forum.component.css']
})
export class SearchForumComponent implements OnInit {

  name:string;
  forums: Forum[];
  subforums: Subforum[];
  topics: Topic[];

  constructor(private fs: ForumService, private sfs: SubforumService, private ts: TopicService) { }

  ngOnInit() {
    this.name = '';

    this.fs.getForums()
    .subscribe(forums => this.forums);
    this.sfs.getSubforums()
    .subscribe(subforums => this.subforums);
    this.ts.getTopics()
    .subscribe(topics => this.topics)
  }

  private searchForumsFirst() {
    
  }

  

  

  onSubmitFirst() {
    this.searchForumsFirst();
  }

  

}
