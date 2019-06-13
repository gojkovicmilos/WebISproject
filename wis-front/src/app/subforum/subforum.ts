import Forum from '../forum/forum';
import Topic from '../topic/topic';

export default class Subforum {
    id: number;
    name: string;
    creationDate:Date;
    forum: Forum;
    topics: Topic[];
    creator: String;
    
}