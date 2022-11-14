package de.thaso.demo.examples.templates.consumer.rest.dto;

public class BookDto{
    private Long id;
    private String title;
    private String content;
    private String author;

    public BookDto() {}

    public BookDto(
            final Long id,
            final String title,
            final String content,
            final String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDto{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", author='" + author + '\'' +
            '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(final Long value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(final String value) {
        this.title = value;
    }

    public String getContent() {
        return content;
    }
    public void setContent(final String value) {
        this.content = value;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(final String value) {
        this.author = value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Builder() {}

        private Long id;
        private String title;
        private String content;
        private String author;

        public Builder withId(final Long value) {
            this.id = value;
            return this;
        }

        public Builder withTitle(final String value) {
            this.title = value;
            return this;
        }

        public Builder withContent(final String value) {
            this.content = value;
            return this;
        }

        public Builder withAuthor(final String value) {
            this.author = value;
            return this;
        }

        public BookDto build() {
            final BookDto result = new BookDto();
            result.id = id;
            result.title = title;
            result.content = content;
            result.author = author;
            return result;
        }
    }
}
