import { Component, OnInit } from '@angular/core';

import { webSocket } from 'rxjs/webSocket' // for RxJS 6, for v5 use Observable.webSocket
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';
import { UserService } from '../user.service';
import User from '../User';


export class Message {

  constructor(
      public sender: string,
      public content: string,
      public isBroadcast = false,
  ) { }
}

export class AppMessage {
 

 

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
  users: User[];
  usernames: string[] = [];
  username:string = localStorage.getItem("username");

  ngOnInit() {
    this.us.getAllUsers().subscribe((data: User[]) => {
      this.users = data;
      //console.log(this.users);
      for(var i = 0; i < this.users.length; i++) { 
        if(this.users[i].username != this.username)
          this.usernames.push(this.users[i].username);
      }
      //console.log(this.usernames);

     
    });
    console.log(this.usernames);
    
  }

  private subject;
 
  receiver: string = 'everyone';
  private msg = "";
  private lista:AppMessage[] = [];


  constructor(private us: UserService) {
    this.subject = webSocket('ws://localhost:8080/ws');
    this.subject.subscribe(
       (msg)=>{
         this.lista.push(msg);
        },
       (err) => console.log(err),
       () => console.log('complete')
     );
  }


    send(){
      let msg:AppMessage = new AppMessage();
      msg.body = this.msg;
      msg.sender = localStorage.getItem('username');
      msg.receiver = this.receiver;
      this.subject.next(msg);
      console.log('tu sam');
    }
    sendToEveryone(){
      let msg:AppMessage = new AppMessage();
      msg.body = this.msg;
      msg.sender = localStorage.getItem('username');
      msg.receiver = 'everyone';
      this.subject.next(msg);
      console.log('tu sam');
    }

    setReciever(rec: string): void {
      this.receiver = rec;
      console.log(this.receiver);
    }

    sendToAll(): void {
      this.receiver = "everyone";
      console.log(this.receiver);
    }



}
