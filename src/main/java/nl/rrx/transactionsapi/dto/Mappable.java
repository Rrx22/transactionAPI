package nl.rrx.transactionsapi.dto;

import nl.rrx.transactionsapi.entity.BaseEntity;

public interface Mappable<E extends BaseEntity, Q extends Request, R extends Response> {

    E mapRequest(Q request) throws MappingException;
    R mapResponse(E entity) throws MappingException;

}
