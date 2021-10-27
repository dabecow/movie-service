package org.movies.response;

import lombok.Data;

import java.util.Collection;

@Data
public class PageableResponse <T>{
    private long offset;
    private long limit;
    private long total;
    private Collection<T> data;

    public PageableResponse(long offset, long limit, long total, Collection<T> data) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.data = data;
    }

    public PageableResponse() {
    }
}
