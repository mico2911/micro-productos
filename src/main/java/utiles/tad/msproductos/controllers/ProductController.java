package utiles.tad.msproductos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utiles.tad.msproductos.entities.Product;
import utiles.tad.msproductos.services.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/api/products")
    public List<Product> getAll () {
        return service.getAll();
    }

    @GetMapping("/api/products/{id}")
    public Product getById (@PathVariable String id) {
        return service.getById(Integer.parseInt(id));
    }

    @GetMapping("/api/products/existencia/{id}")
    public String existencia (@PathVariable String id) {
        return service.comprobarExistencia(Integer.parseInt(id));
    }

    @GetMapping("/api/products/stock/{id}")
    public Map<String, Object> stock (@PathVariable String id) {
        return service.stock(Integer.parseInt(id));
    }


    @DeleteMapping("/api/products/{id}")
    public void remove(@PathVariable String id){
        service.remove(Integer.parseInt(id));
    }

    @PostMapping("/api/products")
    public void save(@RequestBody Product product){
        service.save(product);
    }
}
