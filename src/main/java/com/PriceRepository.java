package com;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

interface PriceRepository extends JpaRepository<Price, Integer> {

  // Optional<Price> findById(Long id);
  Optional<List<Price>> findTopByStartDateBeforeAndEndDateAfter(LocalDateTime date, LocalDateTime date2,
      Sort sort);
  // void deleteById(Long id);

}