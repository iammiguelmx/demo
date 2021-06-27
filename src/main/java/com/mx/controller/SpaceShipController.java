package com.mx.controller;

import com.mx.model.SpaceShip;
import com.mx.repository.SpaceShipRepository;
import com.sun.istack.Nullable;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Controller(value="/spaceship")
@RequiredArgsConstructor
public class SpaceShipController {

    private final SpaceShipRepository repository;

    @Get("/gimme")
    @Operation(summary = "Greets a person",
            description = "A friendly greeting is returned"
    )
    @ApiResponse(
            content = @Content(mediaType = "text/plain",
                    schema = @Schema(type="string"))
    )
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "gimme")
    public Iterable<SpaceShip> gimme(){
        return repository.findAll();
    }

    @Delete("/delete/{id:2}")
    public SpaceShip delete(@PathVariable Integer id){
        Optional<SpaceShip> byId = repository.findById(id);
        if (byId.isEmpty())
            throw new IllegalArgumentException("Does not exist: " + id);
        repository.delete(byId.get());
        return byId.get();
    }

    @Post("/")
    public SpaceShip createWithBody(@Body SpaceShip spaceship){
        return repository.save(spaceship);
    }

    @Post("/create/{captain}/{model}/{fuel}")
    public SpaceShip create(@PathVariable String captain, @PathVariable String model, @PathVariable Integer fuel){
        return repository.save(new SpaceShip(null, model, captain, fuel));
    }


    @Post("/update")
    public SpaceShip updateWithBody(@Body SpaceShip spaceship){
        Optional<SpaceShip> byId = repository.findById(spaceship.getId());
        SpaceShip entity = byId.get();
        entity.setCaptain(spaceship.getCaptain());
        entity.setFuel(spaceship.getFuel());
        entity.setModel(spaceship.getModel());
        return repository.update(entity);
    }

    @Post("/queryparams{?model,captain,fuel}")
    public SpaceShip createWithBody(@QueryValue Optional<String> model, @QueryValue @Nullable String captain, @QueryValue @Nullable Integer fuel){
        return repository.save(new SpaceShip(null, model.get(), captain, fuel));
    }
}
