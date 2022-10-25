# GunsNAmmo Rest APIs

### Swagger

     http://localhost:8080/swagger-ui.html

## Run application

    mvn spring-boot:run

### Reference Documentation

## Add guns

### request

`POST /guns`

    http://localhost:8080/api/v2/guns

    [
        {
            "gunId": 1,
            "name": "Ak47",
            "email": "mail@gmail.com"        
        },
        {
            "gunId": 2,
            "name": "Ak47f",
            "email": "mail@gmail.com"       
        }
    ]

## Get a gun

### request

`GET /guns/{gunId}`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v2/guns/1

## Get all guns

### request

`GET /guns`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/guns

## Update a gun

### request

`PUT /guns/{gunId}`

    http://localhost:8080/api/v2/guns/1

    {
        "gunId": 1,
        "name": "Ak47b",
        "email": "mail@gmail.com"    
    }

## Delete a gun

### request

`DELETE /guns/{gunId}`

    http://localhost:8080/api/v2/guns/2

## Partial update a gun

### request

`PATCH /guns/{gunId}`

    http://localhost:8080/api/v2/guns/1

    {
        "name": "M-16"    
    }




