export class Question {
  description_question: String;
  topic: String;
  title: String;
  status = 'Pending';
  datetime: String | null;
  img_src: String;
  qcreated_by: String;
  qapproved_by: String;

  constructor() {}
}
