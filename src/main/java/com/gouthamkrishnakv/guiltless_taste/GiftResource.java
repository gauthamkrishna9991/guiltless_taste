package com.gouthamkrishnakv.guiltless_taste;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/gift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiftResource {

    @GET
    @Path("{id}")
    public Optional<Gift> getById(@PathParam UUID id) {
        return Gift.findByIdOptional(id);
    }

    @POST
    @Transactional
    public Optional<Gift> createGift(Gift gift) {
        if (gift.getId() != null) {
            throw new WebApplicationException("Invalid setting of Gift ID", 422);
        }
        gift.persist();
        return Optional.of(gift);
    }
}
