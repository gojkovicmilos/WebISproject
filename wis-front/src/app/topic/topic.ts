import Subforum from '../subforum/subforum';
import Message from '../message/message';

export default class Topic {
    id: number;
    name: string;
    creationDate:Date;
    subforum:Subforum;
    messages: Message[];
    creator: string;
    
}