package com.algaworks.algafood.domain;

import com.algaworks.algafood.domain.groups.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// @JsonRootName("cozinha") Essa annotation você muda o nome do objeto (Visivel somente na visão XML)
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @EqualsAndHashCode.Include
    @NotNull(groups = Groups.CadastroRestaurante.class)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "cozinha")
    private List<Restaurante> restaurantes = new ArrayList<>();


}
