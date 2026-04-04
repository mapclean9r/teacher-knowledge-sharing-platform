import { Subject } from "./subjects";

export interface Resource {
  id: number;
  title: string;
  description: string;
  grade: string;
  subject: Subject;
  fileUrl?: string;
}

export const dummyResources: Resource[] = [
  { id: 1, title: "Matematikk - Algebra", description: "Introduksjon til algebra for 8. trinn.", grade: "8", subject: Subject.MATHEMATICS },
  { id: 2, title: "Naturfag - Planter", description: "Undervisningsmateriale om planter og fotosyntese.", grade: "6", subject: Subject.NATURAL_SCIENCE },
  { id: 3, title: "Historie - Vikingtid", description: "Vikingtiden og norrøn mytologi.", grade: "7", subject: Subject.HISTORY },
  { id: 4, title: "Matematikk - Geometri", description: "Introduksjon til geometri for 7. trinn.", grade: "7", subject: Subject.MATHEMATICS },
];