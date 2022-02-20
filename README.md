# E commerce application

Things needed to be installed to run project
[Java JDK 8 or above](https://www.oracle.com/java/technologies/javase-downloads.html) and [maven](https://maven.apache.org/)

Database of this application is in memory [H2](https://www.h2database.com/html/main.html)

## Rest endpoint available in this application:
### Cart endpoints:
POST `/cart` support Content types `JSON`:
Endpoint for creating virtual cart

GET `/cart/{cartId}` support Content types `JSON`:
Endpoint for get details of specific cart

POST `/cart/{cartId}/addItem` support Content types `JSON`:
Add item to cart, body example
```
{
    "itemId": <item id>,
    "quantity": <quantity number>
}
```

DELETE `/cart/{cartId}/removeItem` support Content types `JSON`:
Remove item from cart, body example
```
{
    "itemId": <item id>,
}
```
POST `/cart/{cartId}/reduceItem` support Content types `JSON`:
reduce item quantity from cart by one, body example
```
{
    "itemId": <item id>,
}
```
POST `/cart/{cartId}/increaseItem` support Content types `JSON`:
increase item from cart by one, body example
```
{
    "itemId": <item id>,
}
```
### Item endpoints:
GET `/item` support Content types `JSON`: Get list of items in stock

POST `/item` support Content types `JSON`:
Create item
```
{
    "name": "iPhone",
    "description": "Mobile phone from apple organization",
    "price": 30000.00,
    "stock": 6
}
```

POST `/item/{itemId}/increaseStock` support Content types `JSON`:
Increase item stock
```
{
    "stockToAdd": <number to increase>
}
```

POST `/item/{itemId}/decreaseStock` support Content types `JSON`:
Decrease item stock
```
{
    "stockToRemove": <number to decrease>
}
```








