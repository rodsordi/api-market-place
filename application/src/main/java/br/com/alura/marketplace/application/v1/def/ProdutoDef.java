package br.com.alura.marketplace.application.v1.def;

import br.com.alura.marketplace.domain.entity.Carrinho;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface ProdutoDef {

    interface Representado extends Serializable {

        String getNome();

        BigDecimal getValor();
    }

    interface Detalhado extends Serializable, Representado {

        String getDescricao();
    }

    interface RepresentadoPersistido extends Serializable, Representado {

        UUID getProdutoId();

        LocalDateTime getCriadoEm();

        LocalDateTime getAtualizadoEm();
    }

    interface DetalhadoPersistido extends Serializable, RepresentadoPersistido {

    }

    interface Request extends Detalhado {

    }

    interface Response extends DetalhadoPersistido {

    }

    interface Representacao extends RepresentadoPersistido {

    }
}
