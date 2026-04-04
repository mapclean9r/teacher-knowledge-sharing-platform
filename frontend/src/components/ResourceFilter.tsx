"use client";

import { useState, useEffect } from "react";
import "@/styles/resource-filter.scss";
import { Grade, getSchoolLevel } from "@/types/grades";

interface ResourceFilterProps {
  subjects: string[];
  onFilterChange: (filters: { search: string; grade: Grade | ""; subject: string }) => void;
}

export default function ResourceFilter({ subjects, onFilterChange }: ResourceFilterProps) {
  const [search, setSearch] = useState("");
  const [grade, setGrade] = useState<Grade | "">("");
  const [subject, setSubject] = useState("");

  useEffect(() => {
    onFilterChange({ search, grade, subject });
  }, [search, grade, subject, onFilterChange]);

  return (
    <div className="resource-filter">
      {/* Søke-felt */}
      <input
        type="text"
        placeholder="Search by title or description..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      {/* Grade dropdown */}
      <select value={grade} onChange={(e) => setGrade(e.target.value as Grade | "")}>
        <option value="">All Grades</option>
        {Object.values(Grade).map((g) => (
          <option key={g} value={g}>
            {getSchoolLevel(g)}
          </option>
        ))}
      </select>

      {/* Subject dropdown */}
      <select value={subject} onChange={(e) => setSubject(e.target.value)}>
        <option value="">All Subjects</option>
        {subjects.map((s) => (
          <option key={s} value={s}>
            {s}
          </option>
        ))}
      </select>
    </div>
  );
}