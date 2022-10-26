package de.thaso.demo.examples.simplepayroll.producer.service;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private String author;

    public Book() {
    }

    public Book(
        final Long id,
        final String title,
        final String isbn,
        final String author
    ) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public static Builder builder() {
        return new Book.Builder();
    }

    public static class Builder {
        private Builder() {
        }

        private Long id;
        private String title;
        private String isbn;
        private String author;

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder withISBN(final String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder withAuthor(final String author) {
            this.author = author;
            return this;
        }

        public Book build() {
            final Book result = new Book();
            result.id = id;
            result.title = title;
            result.isbn = isbn;
            result.author = author;
            return result;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", isbn='" + isbn + '\'' +
            ", author='" + author + '\'' +
            '}';
    }
}
