package com;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Sort;
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

  // @GetMapping("/prices/{id}")
  // Price one(@PathVariable Long id) {

  // return repository.findById(id)
  // .orElseThrow(() -> new PriceNotFoundException(id));
  // }

  // http://localhost:8080/custom?product_id=35455&brand_id=1&date=2020-06-14T10:00:00

  @RequestMapping(method = RequestMethod.GET, value = "/custom")
  public Optional<List<Price>> controllerMethod(@RequestParam Map<String, String> customQuery) {

    System.out.println(customQuery.toString());
    LocalDateTime date = LocalDateTime.parse(customQuery.get("date"));
    // return customQuery.toString();
    return repository.findTopByStartDateBeforeAndEndDateAfter(date, date, Sort.by(Sort.Direction.DESC, "priority"));
  }

  // @PutMapping("/prices/{id}")

  // @DeleteMapping("/prices/{id}")
  // void deleteEmployee(@PathVariable Long id) {
  // repository.deleteById(id);
  // }
}