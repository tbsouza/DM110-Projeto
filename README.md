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

#### Get Order by ID
Get a specific order by its id.

```bash
GET
http://{{yourlocaldomain}}/api/ralethi/order/{{orderId}}
Content-Type: application/json

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

#### List Orders

```bash
GET
http://{{yourlocaldomain}}/api/ralethi/orders
Content-Type: application/json

Response example (Success):
[
    {
        "id": 1,
        "orderCode": 0001,
        "productCode": 0001,
        "cpf": "000.000.000-00",
        "amount": 3,
        "saleDate": "2019-09-07 11:59 PM",
        "value": 3000
    },
    {
        "id": 2,
        "orderCode": 0002,
        "productCode": 0002,
        "cpf": "000.000.000-00",
        "amount": 3,
        "saleDate": "2019-09-07 11:59 PM",
        "value": 2000
    }
]
```
