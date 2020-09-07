# Demo Spring boot with DynamoDB

## Endpoints

#### Get all Products
```sh
GET /
```
##### Response (200 OK)
```sh
[
    {
        "id": "231ad3fa-9a8a-458f-ba58-d3ec56dd1dde",
        "name": "macbook pro retina",
        "cost": "2500"
    }
]
```

---

#### Create single Product
```sh
POST /
```

##### Body
```sh
{
    "name": "iphone xr",
    "cost": "799"
}
```

##### Response (200 OK)
```sh
{
    "id": "722e6bb8-573f-4c31-ae48-107c48b3137d",
    "name": "iphone xr",
    "cost": "799"
}
```

---

#### Update a single Product
```sh
PUT /{productId}
```

##### Body
```sh
{
    "name": "iphone xr",
    "cost": "799"
}
 ```

##### Response (200 OK)
```sh
{
    "id": "722e6bb8-573f-4c31-ae48-107c48b3137d",
    "name": "iphone xr",
    "cost": "799"
}
```

---

#### Delele a single Product
```sh
DELETE /{productId}
```

##### Response (204 NO CONTENT)
```sh
```

---

### Environment variables
```sh
AWS_ACCESS_KEY
AWS_SECRET_KEY
```