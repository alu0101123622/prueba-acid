package com;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface PriceRepository extends JpaRepository<Price, Integer> {

  // Optional<Price> findById(Long id);

  // void deleteById(Long id);

}