package de.thaso.demo.examples.simplepayroll.consumer.rest.dto;

public class BookDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public BookDto() {
    }

    public BookDto(
        final Long id,
        final String title,
        final String content,
        final String author
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDto{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", author='" + author + '\'' +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Builder() {
        }

        private Long id;
        private String title;
        private String content;
        private String author;

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder withContent(final String content) {
            this.content = content;
            return this;
        }

        public Builder withAuthor(final String author) {
            this.author = author;
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
