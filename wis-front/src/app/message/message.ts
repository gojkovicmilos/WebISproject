import Topic from '../topic/topic';

export default class Message {
    id: number;
    body: string;
    creationDate:Date;
    topic: Topic;
    creator: String;
    creatorPic: Int8Array;
    mimetype: String;
    
}