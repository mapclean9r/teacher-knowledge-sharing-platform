"use client";

import { useState } from "react";
import ResourceList from "@/components/ResourceList";
import ResourceFilter from "@/components/ResourceFilter";
import { dummyResources, Resource } from "@/types/resource";
import { Grade } from "@/types/grades";

export default function HomePage() {
  const [filteredResources, setFilteredResources] = useState<Resource[]>(dummyResources);

  const subjects = Array.from(new Set(dummyResources.map((r) => r.subject)));

  const handleFilterChange = ({
    search,
    grade,
    subject,
  }: {
    search: string;
    grade: Grade | "";
    subject: string;
  }) => {
    const filtered = dummyResources.filter((r) => {
      const matchesSearch =
        r.title.toLowerCase().includes(search.toLowerCase()) ||
        r.description.toLowerCase().includes(search.toLowerCase());
      const matchesGrade = grade ? r.grade === grade : true;
      const matchesSubject = subject ? r.subject === subject : true;
      return matchesSearch && matchesGrade && matchesSubject;
    });

    setFilteredResources(filtered);
  };

  return (
    <div style={{ maxWidth: 1200, margin: "0 auto", padding: 30 }}>
      <h1 style={{ fontSize: 28, marginBottom: 20 }}>Resources</h1>
      

      <ResourceFilter subjects={subjects} onFilterChange={handleFilterChange} />

      <ResourceList resources={filteredResources} />
    </div>
  );
}