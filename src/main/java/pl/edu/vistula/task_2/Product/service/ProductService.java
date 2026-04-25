package pl.edu.vistula.task_2.Product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.task_2.Product.api.request.ProductRequest;
import pl.edu.vistula.task_2.Product.api.request.UpdateProductRequest;
import pl.edu.vistula.task_2.Product.api.response.ProductResponse;
import pl.edu.vistula.task_2.Product.domain.Product;
import pl.edu.vistula.task_2.Product.repository.OldProductRepository;
import pl.edu.vistula.task_2.Product.repository.ProductRepository;
import pl.edu.vistula.task_2.Product.support.ProductExceptionSupplier;
import pl.edu.vistula.task_2.Product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository oldProductRepository;
    private final ProductMapper productMapper;
    public ProductService(ProductRepository oldProductRepository, ProductMapper productMapper) {
        this.oldProductRepository = oldProductRepository;
        this.productMapper = productMapper;
    }
    public ProductResponse create(ProductRequest productRequest){
        Product product = oldProductRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }
    public ProductResponse find(Long id){
        Product product = oldProductRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }
    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest){
        Product product = oldProductRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        oldProductRepository.save(productMapper.toProduct(product,updateProductRequest));
        return productMapper.toProductResponse(product);
    }
    public List<ProductResponse> findall() {
        return oldProductRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }
    public void delete(Long id){
        Product product = oldProductRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        oldProductRepository.deleteById(product.getId());
    }
}
