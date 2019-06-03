import YearOfStudy from './YearOfStudy';
import Center from './Center';

export default class StudyProgram {
    id: number;
    name: string;
    yearsOfStudy: YearOfStudy[];
    center: Center = new Center();
    img_src: string;
}