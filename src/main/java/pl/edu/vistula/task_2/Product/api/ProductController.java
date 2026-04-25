package pl.edu.vistula.task_2.Product.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.task_2.Product.api.request.ProductRequest;
import pl.edu.vistula.task_2.Product.api.request.UpdateProductRequest;
import pl.edu.vistula.task_2.Product.api.response.ProductResponse;
import pl.edu.vistula.task_2.Product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.create(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id){
        ProductResponse productResponse = productService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest){
        ProductResponse productResponse  = productService.update(id,updateProductRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<ProductResponse> productResponses = productService.findall();
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
