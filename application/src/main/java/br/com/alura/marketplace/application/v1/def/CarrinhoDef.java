package br.com.alura.marketplace.application.v1.def;

import br.com.alura.marketplace.domain.entity.Carrinho;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CarrinhoDef {

    interface Representado extends Serializable {

        UUID getClienteId();
    }

    interface Detalhado extends Serializable, Representado {

    }

    interface RepresentadoPersistido extends Serializable, Representado {

        UUID getCarrinhoId();

        Carrinho.Status getStatus();

        BigDecimal getValorTotal();

        LocalDateTime getCriadoEm();

        LocalDateTime getAtualizadoEm();
    }

    interface DetalhadoPersistido extends Serializable, RepresentadoPersistido {

    }

    interface Request extends Detalhado {

        List<? extends ProdutoDef.Request> getProdutos();
    }

    interface Response extends DetalhadoPersistido {

        List<? extends ProdutoDef.Response> getProdutos();
    }

    interface Representacao extends RepresentadoPersistido {

    }
}
