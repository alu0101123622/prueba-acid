package com;

class PriceNotFoundException extends RuntimeException {

  PriceNotFoundException(Long id) {
    super("Could not find price " + id);
  }
}