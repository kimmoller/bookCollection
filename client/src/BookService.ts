import { useEffect, useState } from "react";

export interface Book {
    id: number;
    title: string;
    author: string;
    description: string;
}

export function fetchBookCollection(): Promise<Book[]> {
    return fetch("http://localhost:8080/getAll")
        .then(response => response.json())
        .then(data => {
            return data;
        })
        .catch(() => {
            return "Book list missing...";
        });
}