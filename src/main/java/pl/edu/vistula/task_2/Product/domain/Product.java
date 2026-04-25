package pl.edu.vistula.task_2.Product.domain;

public class Product {

    private Long id;

    private String name;

    public Product() {}

    public Product(String name) {this.name = name;}

    public Long getId() {return id;}

    public String getName() {return name;}

    public void setId(Long id) {this.id = id;}

    public void setName(String name) {this.name = name;}
}