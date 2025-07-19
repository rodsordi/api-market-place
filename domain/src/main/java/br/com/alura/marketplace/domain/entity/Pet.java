package br.com.alura.marketplace.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Builder
@EqualsAndHashCode
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Pet {

    @Id
    @GeneratedValue
    private UUID petId;

    @Column
    private String nome;

    @Column
    private String categoria;

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

    @CreatedDate
    @Column
    private LocalDateTime criadoEm;

    @LastModifiedDate
    @Column
    private LocalDateTime atualizadoEm;
}
