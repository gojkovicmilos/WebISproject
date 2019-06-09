import { Component, OnInit } from '@angular/core';

import { webSocket } from 'rxjs/webSocket' // for RxJS 6, for v5 use Observable.webSocket
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';


export class Message {

  constructor(
      public sender: string,
      public content: string,
      public isBroadcast = false,
  ) { }
}

export class AppMessage{

  public sender:String;
  public receiver:String;
  public body:String;

  constructor(){}
}


@Component({
  selector: 'app-websocket',
  templateUrl: './websocket.component.html',
  styleUrls: ['./websocket.component.css']
})
export class WebsocketComponent implements OnInit {

  ngOnInit() {
  }

  private subject;
  private msg = "";
  private lista:AppMessage[] = [];


  constructor() {
    this.subject = webSocket('ws://localhost:8080/ws');
    this.subject.subscribe(
       (msg)=>{
         this.lista.push(msg);
        },
       (err) => console.log(err),
       () => console.log('complete')
     );
  }


    sent(){
      let msg:AppMessage = new AppMessage();
      msg.body = this.msg;
      msg.sender = 'sender';
      msg.receiver = 'receiver';
      this.subject.next(JSON.stringify(msg));
      this.msg = "";
    }



}
