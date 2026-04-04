"use client";

import Link from "next/link";
import { useState, useEffect } from "react";
import "@/styles/header.scss";

export default function Header() {
  const [token, setToken] = useState<string | null>(null);

  useEffect(() => {
    const t = localStorage.getItem("authToken");
    setToken(t);
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("authToken");
    setToken(null);
    alert("Logged out!");
  };

  return (
    <header className="app-header">
      <div className="logo">
        <h1>TeacherPlatform</h1>
      </div>

      <nav className="nav-links">
        <Link href="/resources">Ressurser</Link>
        <Link href="/favorites">Favoritter</Link>
      </nav>

      <div className="actions">
        {token ? (
          <>
            <span className="username">Bruker</span>
            <button className="logout-btn" onClick={handleLogout}>
              Logout
            </button>
          </>
        ) : (
          <Link href="/login">
            <button className="login-btn">Login</button>
          </Link>
        )}
      </div>
    </header>
  );
}