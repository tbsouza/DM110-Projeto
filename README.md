# DM110
DM110 - Desenvolvimento JavaEE

If you prefer the collection, take a look at [postman](TODO).
Don't forget to change domain as your local server is configured.

## Requests

#### Create Order

Insert a new order in database.

```bash
POST
http://{{yourlocaldomain}}/api/ralethi/order
Content-Type: application/json

Body:

{
    "orderCode": 0001,
    "productCode": 0001,
    "cpf": "000.000.000-00",
    "amount": 3,
    "saleDate": "2019-09-07 11:59 PM",
    "value": 3000
}

Response example (Success):

{
    "id": 1,
    "orderCode": 0001,
    "productCode": 0001,
    "cpf": "000.000.000-00",
    "amount": 3,
    "saleDate": "2019-09-07 11:59 PM",
    "value": 3000
}
```
