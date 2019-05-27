import { Injectable } from '@angular/core';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable({
  providedIn: 'root'
})
export class CommunicationService {

private messageSource = new BehaviorSubject<{}>({});
currentMessage = this.messageSource.asObservable();

constructor() { }

changeMessage(message: {}) {
  this.messageSource.next(message);
}

}




