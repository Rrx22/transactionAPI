package nl.rrx.transactionsapi.dto.category;

import nl.rrx.transactionsapi.dto.Request;
import nl.rrx.transactionsapi.dto.Response;

public class CategoryDTO implements Request, Response {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
