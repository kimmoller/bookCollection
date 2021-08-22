import React from "react";
import { Component } from "react";
import { Book, fetchBookCollection } from "./BookService";

interface State {
  books: Book[]
}

interface Props { }

export default class App extends Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = {
      books: []
    }
  }

  getBookCollection() {
    fetchBookCollection().then(books => {
      this.setState({
        books: books
      })
    })
  }

  componentDidMount() {
    this.getBookCollection();
  }

  render() {
    return (
      <div>
        <h1>Book Collection</h1>
        <ul>
          {this.state.books.map(book => {
            return <li>{book.title}</li>
          })}
        </ul>
      </div>
    )
  }
}