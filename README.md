## Admin Controller API Documentation

This document outlines the RESTful API endpoints provided by the Admin Controller for managing grocery items.

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
- **Example Response**: `200 OK` with no response body.

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
- **Example Response**: `200 OK` with no response body.

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
- **Example Response**: `200 OK` with no response body.

#### Manage Inventory

- **URL**: `/manage-inventory/{itemId}`
- **Method**: PUT
- **Description**: Manages the inventory quantity of a specific grocery item.
- **Path Parameter**: `itemId` - ID of the grocery item to be managed.
- **Request Parameter**: `quantity` - New quantity to set for the grocery item.
- **Example Request**: `/manage-inventory/123?quantity=50`
- **Example Response**: `200 OK` with no response body.


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

## User Controller API Documentation

This document outlines the RESTful API endpoints provided by the User Controller for managing grocery items.

### Base URL
http://yourdomain.com/user

### Endpoints

#### Get All Available Grocery Items
http://yourdomain.com/user

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

