package br.com.alura.marketplace.application.v1.def;

import br.com.alura.marketplace.domain.entity.Pet;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PetDef {

    interface Representado extends Serializable {

        String getNome();
    }

    interface Detalhado extends Serializable, Representado {

    }

    interface RepresentadoPersistido extends Serializable, Representado {

        UUID getPetId();

        LocalDateTime getCriadoEm();

        LocalDateTime getAtualizadoEm();
    }

    interface DetalhadoPersistido extends Serializable, RepresentadoPersistido {

        String getCategoria();

        Pet.Status getStatus();
    }

    interface Request extends Detalhado {

    }

    interface Response extends DetalhadoPersistido {

        List<String> getUrlFotos();

        List<String> getTags();
    }

    interface Representacao extends RepresentadoPersistido {

    }
}
