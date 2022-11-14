package de.thaso.demo.examples.templates.consumer.service;

public class MyStock{
    private String pos;
    private Integer count;

    public MyStock() {}

    public MyStock(
            final String pos,
            final Integer count) {
        this.pos = pos;
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyStock{" +
            "pos='" + pos + '\'' +
            ", count='" + count + '\'' +
            '}';
    }

    public String getPos() {
        return pos;
    }
    public void setPos(final String value) {
        this.pos = value;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(final Integer value) {
        this.count = value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Builder() {}

        private String pos;
        private Integer count;

        public Builder withPos(final String value) {
            this.pos = value;
            return this;
        }

        public Builder withCount(final Integer value) {
            this.count = value;
            return this;
        }

        public MyStock build() {
            final MyStock result = new MyStock();
            result.pos = pos;
            result.count = count;
            return result;
        }
    }
}
