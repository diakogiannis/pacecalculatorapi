package com.diakogiannis.metropolitan.paper.api;

import com.diakogiannis.metropolitan.paper.entities.PaceDTO;
import com.diakogiannis.metropolitan.paper.service.PaceCalculationService;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/api")
@Slf4j
public class PaceApi {

    final PaceCalculationService paceCalculationService;

    @Inject
    public PaceApi(PaceCalculationService paceCalculationService){
        this.paceCalculationService = paceCalculationService;
    }

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPace(
            @DefaultValue("0") @QueryParam("distance") double distance,
            @DefaultValue("0") @QueryParam("seconds") double seconds
    ) {
        logRequest();
        PaceDTO paceDTO = new PaceDTO(paceCalculationService.calculatePaceFormated(distance,seconds));
        return Response.ok(paceDTO).build();
    }

    private void logRequest(){
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();

        log.info("Request {} from IP {}", path, address);
    }

}