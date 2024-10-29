const axios = require("axios");

async function run() {
  const baseUrl = "http://localhost:8080";

  const createBookUrl = `${baseUrl}/v1/books`;

  const gutendexBaseUrl = "https://gutendex.com";

  const gutendexListBooksUrl = `${gutendexBaseUrl}/books`;

  let next = gutendexListBooksUrl;

  const numberOfPages = 20;
  for (let i = 0; i <= numberOfPages; i++) {
    const { data: gutendexListBooksResponseData } = await axios.get(next);

    for (const gutendexBook of gutendexListBooksResponseData["results"]) {
      const book = new Book(
        gutendexBook["id"].toString(),
        gutendexBook["title"],
        gutendexBook["authors"].map((author) => author.name),
        gutendexBook["subjects"],
        gutendexBook["formats"],
        gutendexBook["download_count"],
      );

      console.log("Creating book: ", book);

      await axios.post(createBookUrl, book);
    }

    next = gutendexListBooksResponseData["next"];
  }
}

class Book {
  constructor(id, title, authors, subjects, formats, downloadCount) {
    this.id = id;
    this.title = title;
    this.authors = authors;
    this.subjects = subjects;
    this.formats = formats;
    this.downloadCount = downloadCount;
  }
}

run();
