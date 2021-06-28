package com.mx.model;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@MappedEntity
@NoArgsConstructor
public class RefreshTokenEntity implements Serializable {

    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter @NotBlank
    private String username;

    @Getter @Setter @NotBlank
    private String refreshToken;

    @Getter @Setter @NotNull
    private Boolean revoked;

    @DateCreated
    @Getter @Setter @NotNull
    private Instant dateCreated;

}