package br.com.alura.marketplace.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
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
    private String categoria;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        AVAILABLE("Disponível"),
        PENDING("Pendente"),
        SOLD("Vendido");

        private final String descricao;
    }

    @Enumerated(STRING)
    @Column
    private Status status;

    @Column
    private String descricao;

    @Column
    private BigDecimal valor;

    @ElementCollection(targetClass = String.class, fetch = EAGER)
    @CollectionTable(name = "foto", joinColumns = @JoinColumn(name = "pet_id"))
    @Column(name = "url_foto", nullable = false)
    @Singular(value = "urlFoto", ignoreNullCollections = true)
    private List<String> urlFotos;

    @ElementCollection(targetClass = String.class, fetch = EAGER)
    @CollectionTable(name = "tag", joinColumns = @JoinColumn(name = "pet_id"))
    @Column(name = "tag", nullable = false)
    @Singular(value = "tag", ignoreNullCollections = true)
    private List<String> tags;

    @Column
    private Long petStorePetId;

    @CreatedDate
    @Column
    private LocalDateTime criadoEm;

    @LastModifiedDate
    @Column
    private LocalDateTime atualizadoEm;

    public void update(Produto produto) {
        if (produto == null)
            return;

        if (produto.nome != null)
            this.nome = produto.nome;

        if (produto.categoria != null)
            this.categoria = produto.categoria;

        if (produto.urlFotos != null)
            this.urlFotos = produto.urlFotos;

        if (produto.tags != null)
            this.tags = produto.tags;

        if (produto.status != null)
            this.status = produto.status;

        if (produto.descricao != null)
            this.descricao = produto.descricao;

        if (produto.valor != null)
            this.valor = produto.valor;

        if (produto.petStorePetId != null)
            this.petStorePetId = produto.petStorePetId;
    }
}
