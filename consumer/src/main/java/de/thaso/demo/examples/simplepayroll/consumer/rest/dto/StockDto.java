package de.thaso.demo.examples.simplepayroll.consumer.rest.dto;

public class StockDto {

    private String pos;
    private Integer count;

    public StockDto() {
    }

    public StockDto(final String pos, final Integer count) {
        this.pos = pos;
        this.count = count;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(final String pos) {
        this.pos = pos;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "StockDto{" +
            "pos='" + pos + '\'' +
            ", count=" + count +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Builder() {
        }

        private String pos;
        private Integer count;

        public Builder withPos(final String pos) {
            this.pos = pos;
            return this;
        }

        public Builder withCount(final Integer count) {
            this.count = count;
            return this;
        }

        public StockDto build() {
            final StockDto result = new StockDto();
            result.pos = pos;
            result.count = count;
            return result;
        }
    }
}
