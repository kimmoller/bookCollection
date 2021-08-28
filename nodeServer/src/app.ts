import express from 'express';

const hostname = '127.0.0.1';
const port = 3000;
const app = express();

interface Book {
    author: string;
    name: string;
    description: string;
}

const book: Book = {
    author: "J. R. Tolkien",
    name: "Lord of the Rings",
    description: "High fantasy"
}

const bookCollection = [book]
app.get('/', (req, res) => res.send('Express + TypeScript server'));
app.get('/getAll', (req, res) => {
    res.send(bookCollection);
});


/* app.use(express.static(__dirname + '../../client/dist')); */

app.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}`);
});