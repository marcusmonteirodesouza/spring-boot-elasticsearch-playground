# Spring Boot + ElasticSearch playground

## Getting started

1. Run `docker compose up -d`.
1. Run `openssl x509 -fingerprint -sha256 -in certs/es01/es01.crt` and set the value of the `ES_CERT_FINGERPRINT` environment variable in the `.env` file to that file.
1. Run `./mvnw spring-boot:run`.
1. Open another terminal in the same folder. Go to [scripts/seed-data](./scripts/seed-data) and run `npm install && npm start`. Wait until the data is seeded.

## Endpoint

### GET `/v1/books/search`

#### Examples

`curl 'http://localhost:8080/v1/books/search`

`curl 'http://localhost:8080/v1/books/search?title=Frankenstein'`

`curl 'http://localhost:8080/v1/books/search?author=Melville'`

`curl 'http://localhost:8080/v1/books/search?subject=Horror'`

`curl 'http://localhost:8080/v1/books/search?title=Frankenstein&author=Melville'`

`curl 'http://localhost:8080/v1/books/search?author=Melville&subject=Horror'`

`curl 'http://localhost:8080/v1/books/search?title=Frankenstein&author=Melville&subject=Horror'`
