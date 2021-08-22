import React from "react";
import { Book } from "./BookService";

interface Props {
    book: Book;
}

export function Book(props: Props) {
    return (
        <div style={{ marginBottom: "8px" }}>
            <span>Title: {props.book.title}</span><br />
            <span>Author: {props.book.author}</span><br />
            <span>Description: {props.book.description}</span>
        </div>
    )
}