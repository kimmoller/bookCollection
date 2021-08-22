import React from "react";
import { Book } from "./Book";
import { useBookCollection } from "./BookService";

export function App() {
  const books = useBookCollection();
  return (
    <div>
      <h1>Book Collection</h1>
      {books.map(book => {
        return <Book book={book} />
      })}
    </div>
  )
}
