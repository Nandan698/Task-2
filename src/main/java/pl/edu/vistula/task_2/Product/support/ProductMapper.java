package pl.edu.vistula.task_2.Product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.task_2.Product.api.request.ProductRequest;
import pl.edu.vistula.task_2.Product.api.response.ProductResponse;
import pl.edu.vistula.task_2.Product.domain.Product;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest){
        return new Product(productRequest.getName());
    }

    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(product.getId(), product.getName());
    }
}
