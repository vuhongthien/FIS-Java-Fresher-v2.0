package coreservlets.model;

public class Book {

  private String title;

  public Book(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public String toString() {
    return title;
  }
}
