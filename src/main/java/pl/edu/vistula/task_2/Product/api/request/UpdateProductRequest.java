package pl.edu.vistula.task_2.Product.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UpdateProductRequest extends ProductRequest{
    private final long id;
    @JsonCreator
    public UpdateProductRequest(String name, long id){
        super(name);
        this.id = id;
    }
    public long getId(){
        return id;
    }
}