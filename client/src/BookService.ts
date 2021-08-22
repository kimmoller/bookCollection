import { useEffect, useState } from "react";

export interface Book {
    id: number;
    title: string;
    author: string;
    description: string;
}

export function useBookCollection() {
    const [books, setBooks] = useState<Book[]>([]);

    useEffect(() => {
        fetchBookCollection().then(books => {
            setBooks(books);
        })
    });

    return books;
}

export async function fetchBookCollection(): Promise<Book[]> {
    let response = await fetch("http://localhost:8080/getAll");
    if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
    }

    let bookJson = await response.json();
    return bookJson;
}