package com.algaworks.algafood.domain;

import com.algaworks.algafood.domain.groups.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @DecimalMin("0")
    @PositiveOrZero
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @ManyToOne//(fetch = FetchType.LAZY)
    // @JsonIgnore
    // @JsonIgnoreProperties(value = "hibernateLazyInitializer")
    @JoinColumn(name = "cozinha_id", nullable = false)
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Groups.CozinhaId.class)
    //@JoinColumn(name = "cozinha_codigo") aqui voce pode colocar um nome padrao para a FK
    private Cozinha cozinha;

    @Embedded
    @JsonIgnore
    private Endereco endereco;

    @Column(nullable = false, columnDefinition = "timestamp")
    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime dataCadastro;

    @Column(nullable = false, columnDefinition = "timestamp")
    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime dataAtualizacao;

    @ManyToMany//(fetch = FetchType.EAGER)
   // @JsonIgnore
    @JoinTable(name = "restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "restaurante_id"),// Defini a coluna que faz referencia a tabela atual
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos = new ArrayList<>();
}
