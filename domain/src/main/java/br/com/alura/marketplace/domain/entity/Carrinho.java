package br.com.alura.marketplace.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Builder
@EqualsAndHashCode
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Carrinho implements Serializable {

    @Id
    @GeneratedValue
    private UUID carrinhoId;

    public enum Status {ATIVO, FINALIZADO, CANCELADO}

    private Status status;

    @Column
    private BigDecimal valorTotal;

    @Column
    private UUID clienteId;

    @Singular(value = "produto", ignoreNullCollections = true)
    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "carrinho_id", updatable = false, nullable = false)
    @OrderBy("atualizadoEm desc")
    @Valid
    private List<Produto> produtos;

    @CreatedDate
    @Column
    private LocalDateTime criadoEm;

    @LastModifiedDate
    @Column
    private LocalDateTime atualizadoEm;
}
