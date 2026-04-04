"use client";

import "@/styles/header.scss";
import Link from "next/link";

export default function Header() {
  return (
    <header className="app-header">
      {/* Venstre del */}
      <div className="logo">
        <h1>TeacherPlatform</h1>
      </div>

      {/* Midt */}
      <nav className="nav-links">
        <Link href="/resources">Ressurser</Link>
        <Link href="/favorites">Favoritter</Link>
      </nav>

      {/* Høyre */}
      <div className="actions">
        <button className="login-btn">Login</button>
      </div>
    </header>
  );
}