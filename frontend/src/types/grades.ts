export enum Grade {
  G1 = "1",
  G2 = "2",
  G3 = "3",
  G4 = "4",
  G5 = "5",
  G6 = "6",
  G7 = "7",
  G8 = "8",
  G9 = "9",
  G10 = "10",
  G11 = "11",
  G12 = "12",
  G13 = "13",
}
export const allGrades = Object.values(Grade);

export type SchoolLevel = "Barneskole" | "VGS";

export function getSchoolLevel(grade: Grade | number): string | undefined {
  const num = typeof grade === "number" ? grade : parseInt(grade);

  if (num >= 1 && num <= 10) return `${num} trinn`;
  if (num == 11) return `VG1`;
  if (num == 12) return `VG2`;
  if (num == 13) return `VG3`;
  

  return undefined;
}