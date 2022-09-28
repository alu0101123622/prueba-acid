package com;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PriceController {

  private final PriceRepository repository;

  PriceController(PriceRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/prices")
  List<Price> all() {
    return repository.findAll();
  }

  @PostMapping("/prices")
  Price newEmployee(@RequestBody Price newPrice) {
    return repository.save(newPrice);
  }

  // Single item

  @GetMapping("/prices/{id}")
  Price one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new PriceNotFoundException(id));
  }

  // http://localhost:2000/custom?brand=dell&limit=20&price=20000&sort=asc

  @RequestMapping(method = RequestMethod.GET, value = "/custom")
  public String controllerMethod(@RequestParam Map<String, String> customQuery) {

    System.out.println("customQuery = datetime " + customQuery.containsKey("datetime"));
    System.out.println("customQuery = product_id " + customQuery.containsKey("product_id"));
    System.out.println("customQuery = brand_id " + customQuery.containsKey("brand_id"));

    System.out.println(customQuery.toString());
    return customQuery.toString();
  }

  @PutMapping("/prices/{id}")

  @DeleteMapping("/prices/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}