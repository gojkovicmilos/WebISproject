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
 

 

  public sender:string;
  public receiver:string;
  public body:string;

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
  openPrivate: boolean = false;
  private subject;
  private receiver: string = 'everyone';
  private msg = "";
  private msgForPrivate = "";
  private lista:AppMessage[] = [];
  str: string = "";
  unreadList:Map<string, number> = new Map();
  listaTrazenihKorisnika:string[] = [];
  invalidUsername: boolean = false;
  private showButton = false;

  ngOnInit() {
    this.us.getAllUsers().subscribe((data: User[]) => {
      this.users = data;
      //console.log(this.users);
      for(var i = 0; i < this.users.length; i++) { 
        if(this.users[i].username != this.username)
        {
          this.usernames.push(this.users[i].username);
          this.listaTrazenihKorisnika.push(this.users[i].username);
          this.unreadList.set(this.users[i].username, 0);
        }
      }
      //console.log(this.usernames);

     
    });
    console.log(this.usernames);
    
  }



  constructor(private us: UserService) {
    this.subject = webSocket('ws://localhost:8080/ws');
    this.subject.subscribe(
       (msg)=>{
         this.lista.push(msg);
         if(this.lista[this.lista.length-1].receiver == this.username)
          this.addNewUnread(this.lista[this.lista.length-1].sender);
          //this.setReciever(this.lista[this.lista.length-1].sender);
        },
       (err) => console.log(err),
       () => console.log('complete')
     );
  }


    send(){
      let msg:AppMessage = new AppMessage();
      msg.body = this.msgForPrivate;
      msg.sender = localStorage.getItem('username');
      msg.receiver = this.receiver;
      this.subject.next(msg);
      //console.log('tu sam');
      this.msgForPrivate = "";
      this.back();
    }
    sendToEveryone(){
      let msg:AppMessage = new AppMessage();
      msg.body = this.msg;
      msg.sender = localStorage.getItem('username');
      msg.receiver = 'everyone';
      this.subject.next(msg);
      //console.log('tu sam');
      this.msg = "";
      this.back();
    }

    setReciever(rec: string): void {
        this.receiver = rec;
        console.log(this.receiver);
        this.openPrivate = true;
        this.resetUnread(rec);
        this.back();
    }

    setSearch()
    {
      if(this.listaTrazenihKorisnika.length == 1)
      {
        this.setReciever(this.listaTrazenihKorisnika[0]);
        this.invalidUsername = false;
      }
      else this.invalidUsername = true;
    }

    closePrivate(): void {
      this.openPrivate = false;
    }
    sendToAll(): void {
      this.receiver = "everyone";
      console.log(this.receiver);
    }

    addNewUnread(username:string)
    {
      this.unreadList.set(username, this.unreadList.get(username)+1);
    }

    displayUnread(i:number):number
    {
      return this.unreadList.get(this.usernames[i]);
    }

    resetUnread(rec:string)
    {
      this.unreadList.set(rec, 0);
    }

    

    pretraga() { 
      console.log(this.str);
      this.listaTrazenihKorisnika = [];
      for(var i = 0; i < this.usernames.length; i++) {
        if(this.usernames[i].toLowerCase().includes( this.str.toLowerCase() )) {
          this.listaTrazenihKorisnika.push(this.usernames[i]);
        }
      }
      if(this.str == "")
      this.listaTrazenihKorisnika = this.usernames;
    }

    back(): void {
      this.invalidUsername = false;
    }

    provera() {
      for(var i = 0; i < this.usernames.length; i++) {
        if(this.usernames[i] == this.str) {
          this.showButton = true;
          return;
        }
      }
      this.showButton = false;
    }


}
