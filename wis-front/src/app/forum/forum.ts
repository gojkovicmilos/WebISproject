import Subforum from '../subforum/subforum';

export default class Forum {
    id: number;
    name: string;
    creationDate:Date;
    subforums: Subforum[];
    creator: String;
    
}