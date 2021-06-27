package com.mx.repository;

import com.mx.model.SpaceShip;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SpaceShipRepository extends CrudRepository<SpaceShip, Integer> {
}
