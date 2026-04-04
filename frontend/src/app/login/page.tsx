"use client";

import AuthForm from "@/components/AuthForm";

export default function LoginPage() {
  const handleAuthSuccess = (token: string) => {
    localStorage.setItem("authToken", token);
    alert("Authentication successful!");
  };

  return <AuthForm onAuthSuccess={handleAuthSuccess} />;
}