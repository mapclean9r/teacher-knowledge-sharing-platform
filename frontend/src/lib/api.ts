import { Page, Resource } from "@/types/resource";

const BASE_URL = "http://localhost:8080";

export async function getResources(page = 0, size = 10): Promise<Page<Resource>> {
  try {
    const res = await fetch(`${BASE_URL}/resources?page=${page}&size=${size}`, {
      cache: "no-store",
    });

    if (!res.ok) {
      // Prøv å hente feilmelding, men fallback til tom streng hvis body mangler
      let errorText = "";
      try {
        errorText = await res.text();
      } catch {
        errorText = "<no response body>";
      }
      throw new Error(`Failed to fetch: ${res.status} ${res.statusText} - ${errorText}`);
    }

    // Hvis alt ok, parse JSON
    const data = (await res.json()) as Page<Resource>;
    return data;
  } catch (error: unknown) {
    console.error("Error fetching resources:", error);
    throw new Error("Could not fetch resources. Please try again later.");
  }
}