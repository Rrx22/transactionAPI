package nl.rrx.transactionsapi.dto.categoryfilter;

import nl.rrx.transactionsapi.dto.Request;
import nl.rrx.transactionsapi.dto.Response;

public class CategoryFilterDTO implements Request, Response {
    private String filter;
    private String category;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
