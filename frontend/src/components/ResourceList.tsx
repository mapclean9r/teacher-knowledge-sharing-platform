'use client';

import { Resource } from "@/types/resource";
import "@/styles/resource-list.scss";

interface ResourceListProps {
  resources: Resource[];
}

export default function ResourceList({ resources }: ResourceListProps) {
  return (
    <div className="resource-list">
      {resources.map((r) => (
        <div key={r.id} className="resource-card">
          <h3>{r.title}</h3>
          <p>{r.description}</p>
          <span>Grade: {r.grade}</span>
          {r.fileUrl && <a href={r.fileUrl}>Open file</a>}
        </div>
      ))}
    </div>
  );
}