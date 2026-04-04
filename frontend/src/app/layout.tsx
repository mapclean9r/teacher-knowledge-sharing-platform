import Header from "@/components/Header";
import "@/styles/globals.scss";

export const metadata = {
  title: "Teacher Platform",
  description: "A platform for teachers to share resources",
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <body>
        <Header />
        {children}
      </body>
    </html>
  );
}