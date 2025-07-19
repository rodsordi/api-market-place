package br.com.alura.marketplace.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Builder
@EqualsAndHashCode
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private UUID produtoId;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private BigDecimal valor;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "petId", updatable = false, nullable = false)
    @Valid
    private Pet pet;

    @CreatedDate
    @Column
    private LocalDateTime criadoEm;

    @LastModifiedDate
    @Column
    private LocalDateTime atualizadoEm;
}
