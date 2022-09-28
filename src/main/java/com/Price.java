package com;

import java.time.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Price {

  private @Id int price_list;
  private int brand_id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int product_id;
  private int priority;
  private float price;
  private String iso;

  Price() {
  }

  public Price(int price_list, int brand_id, LocalDateTime start_date, LocalDateTime end_date, int product_id,
      int priority, float price, String iso) {
    this.price_list = price_list;
    this.brand_id = brand_id;
    this.startDate = start_date;
    this.endDate = end_date;
    this.product_id = product_id;
    this.priority = priority;
    this.price = price;
    this.iso = iso;
  }

  public int getBrandId() {
    return this.brand_id;
  }

  public void setId(int brand_id) {
    this.brand_id = brand_id;
  }

  public int getPrice_list() {
    return price_list;
  }

  public void setPrice_list(int price_list) {
    this.price_list = price_list;
  }

  public int getBrand_id() {
    return brand_id;
  }

  public void setBrand_id(int brand_id) {
    this.brand_id = brand_id;
  }

  public LocalDateTime getStart_date() {
    return startDate;
  }

  public void setStart_date(LocalDateTime start_date) {
    this.startDate = start_date;
  }

  public LocalDateTime getEnd_date() {
    return endDate;
  }

  public void setEnd_date(LocalDateTime end_date) {
    this.endDate = end_date;
  }

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getIso() {
    return iso;
  }

  public void setIso(String iso) {
    this.iso = iso;
  }

  @Override
  public String toString() {
    return "Price [brand_id=" + brand_id + ", end_date=" + endDate + ", iso=" + iso + ", price=" + price
        + ", price_list=" + price_list + ", priority=" + priority + ", product_id=" + product_id + ", start_date="
        + startDate + "]";
  }

}