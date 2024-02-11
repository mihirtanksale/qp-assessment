## Admin Controller API Documentation

This document outlines the RESTful API endpoints provided by the Admin Controller for managing grocery items.

### Base URL

```
http://yourdomain.com/admin
```

### Endpoints

#### Add Grocery Item

- **URL**: `/add-item`
- **Method**: POST
- **Description**: Adds a new grocery item to the inventory.
- **Request Body**: JSON object representing the `GroceryItemDTO`.
  - `name`: Name of the grocery item.
  - `price`: Price of the grocery item.
  - `quantity`: Quantity of the grocery item.
- **Example Request**:
  ```json
  {
    "name": "Apples",
    "price": 2.50,
    "quantity": 100
  }
  ```
- **Example Response**: `200 OK` with message "Grocery item added successfully."

#### Get All Grocery Items

- **URL**: `/grocery-items`
- **Method**: GET
- **Description**: Retrieves a list of all grocery items in the inventory.
- **Example Response**:
  ```json
  [
    {
      "name": "Apples",
      "price": 2.50,
      "quantity": 100
    },
    {
      "name": "Bananas",
      "price": 1.75,
      "quantity": 50
    },
    ...
  ]
  ```

#### Remove Grocery Item

- **URL**: `/remove-item/{itemId}`
- **Method**: DELETE
- **Description**: Removes a specific grocery item from the inventory.
- **Path Parameter**: `itemId` - ID of the grocery item to be removed.
- **Example Request**: `/remove-item/123`
- **Example Response**: `200 OK` with message "Grocery item removed successfully."

#### Update Grocery Item

- **URL**: `/update-item`
- **Method**: PUT
- **Description**: Updates the details of an existing grocery item.
- **Request Body**: JSON object representing the `GroceryItemDTO`.
  - `id`: ID of the grocery item to be updated.
  - `name`: New name of the grocery item.
  - `price`: New price of the grocery item.
  - `quantity`: New quantity of the grocery item.
- **Example Request**:
  ```json
  {
    "id": 123,
    "name": "Oranges",
    "price": 3.00,
    "quantity": 75
  }
  ```
- **Example Response**: `200 OK` with message "Grocery item updated successfully."

#### Manage Inventory

- **URL**: `/manage-inventory/{itemId}`
- **Method**: PUT
- **Description**: Manages the inventory quantity of a specific grocery item.
- **Path Parameter**: `itemId` - ID of the grocery item to be managed.
- **Request Parameter**: `quantity` - New quantity to set for the grocery item.
- **Example Request**: `/manage-inventory/123?quantity=50`
- **Example Response**: `200 OK` with message "Inventory managed successfully."


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

## User Controller API Documentation

This document outlines the RESTful API endpoints provided by the User Controller for managing grocery items.

### Base URL

```
http://yourdomain.com/admin
```

### Endpoints

#### Get All Available Grocery Items

- **URL**: `/available-items`
- **Method**: GET
- **Description**: Retrieves a list of all available grocery items.
- **Example Response**:
  ```json
  [
    {
      "name": "Apples",
      "price": 2.50,
      "quantity": 100
    },
    {
      "name": "Bananas",
      "price": 1.75,
      "quantity": 50
    },
    ...
  ]

### Create Order

- **URL**: `/create-order`
- **Method**: POST
- **Description**: Creates a new grocery order.
- **Request Body**: List of `GroceryOrderDTO` objects.
  ```json
  [
    {
      "itemName": "Apples",
      "quantity": 2
    },
    {
      "itemName": "Bananas",
      "quantity": 3
    }
  ]
- **Example Response**: `200 OK` with message "Order created successfully."

### Docker Integration 

#### command for create and running docker container of mysql 
- docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=Mihir@1611 -e MYSQL_DATABASE=grocery mysql:latest

#### create docker container of springboot project
- docker build -t springboot-mysql-docker .  

#### create new network
- docker network create spring-network

#### connect to newly created network 
- docker network connect spring-network mysqldb

#### command for running docker container of springboot application
- docker run -p 9090:8080 --name springboot-mysql-docker --net spring-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PORT=3307 springboot-mysql-docker

