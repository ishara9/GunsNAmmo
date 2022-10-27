# GunsNAmmo Rest APIs

### Swagger

     http://localhost:8080/swagger-ui.html

### Actuator

    http://localhost:8080/actuator

### H2 Database console

    http://localhost:8080/h2

## Run application

    mvn spring-boot:run

### Reference Documentation

## Add guns

### request

`POST /guns-n-ammo/guns`

    http://localhost:8080/guns-n-ammo/api/v2/guns

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

`GET /guns-n-ammo/guns/{gunId}`

    curl -i -H 'Accept: application/json' http://localhost:8080/guns-n-ammo/api/v2/guns/1

## Get all guns

### request

`GET /guns-n-ammo/guns`

    curl -i -H 'Accept: application/json' http://localhost:8080/guns-n-ammo/api/v1/guns

## Update a gun

### request

`PUT /guns-n-ammo/guns/{gunId}`

    http://localhost:8080/guns-n-ammo/api/v2/guns/1

    {
        "gunId": 1,
        "name": "Ak47b",
        "email": "mail@gmail.com"    
    }

## Delete a gun

### request

`DELETE /guns-n-ammo/guns/{gunId}`

    http://localhost:8080/guns-n-ammo/api/v2/guns/2

## Partial update a gun

### request

`PATCH /guns-n-ammo/guns/{gunId}`

    http://localhost:8080/guns-n-ammo/api/v2/guns/1

    {
        "name": "M-16"    
    }




