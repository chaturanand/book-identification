# book-identification
This is the repository of finding the book identification


# The postamn collection of api are as follows

# save the book identification ,bin and book information

curl --location --request POST 'localhost:8082/api/v1/bookidentifications/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookIdentificationNumber": "b102",
    "bin": "BAA-999-999",
    "isInLibrary": false,
    "book": {
        "title": "Clean Code2",
        "author": "Bob Martin2",
        "availableFrom": "2014­12­252"
    }
}'

# get the book identification  inforamation
curl --location --request GET 'localhost:8082/api/v1/bookidentifications/'

# get the book
curl --location --request GET 'localhost:8082/api/v1/books' \
--data-raw ''


