# Task 2 - Spring Rest API with H2 DB

This is a REST API that can create, read, update and delete products, with Spring Boot and an H2 database.

## Endpoints

---

### Adding a new Product

``POST  - http://localhost:8080/api/v1/products
``

![PostAdding.png](img/PostAdding.png)
- The Client can enter the name for the product in JSON and POST it
- The system then Generates a Unique id based on the count of products added 
- Returns the Name and the Generated ID back to the user 
- With 201 Created status

![Post.png](img/Controller/Post.png)
- `@PostMapping` Create method listen to Post request
- `@RequestBody` Reads the JSON from Postman here 
- The request is then passed to the `create` in service
- Returns the response with created status 

![create.png](img/Service/create.png)
- Inside the create the product request is transformed into a product using `toProduct` from Mapper
- And saved in the repository
- The product is then transformed back into a response and returned
```
protected final Map<Long, Product> map =  new HashMap<>();

protected long counter = 1;

public Product save(Product entity) {
setId(entity);
return entity;
}
private Product setId(Product entity) {
if(entity.getId() != null){
map.put(entity.getId(), entity);
}else{
entity.setId(counter);
map.put(counter, entity);
counter++;
}
return entity;
}
```

- The Products are stored in `HashMap<>`
- The Product is saved in the DB after checking if it already have an ID
- If it doesnt have an id then a new id is generated and assigned

---

``GET http://localhost:8080/api/v1/products/1
``![Screenshot 2026-04-25 143119.png](img/Screenshot%202026-04-25%20143119.png)
- Client can request to get the data of a product just from the id here


---

``GET http://localhost:8080/api/v1/products
``![Screenshot 2026-04-25 143340.png](img/Screenshot%202026-04-25%20143340.png)

``PUT http://localhost:8080/api/v1/products/1
``![Screenshot 2026-04-25 143307.png](img/Screenshot%202026-04-25%20143307.png)

``DELETE http://localhost:8080/api/v1/products/1
``![Screenshot 2026-04-25 143400.png](img/Screenshot%202026-04-25%20143400.png)