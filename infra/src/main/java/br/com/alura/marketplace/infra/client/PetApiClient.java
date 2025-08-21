package br.com.alura.marketplace.infra.client;

import com.petstore.api.PetApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "PetApiClient", url = "${external-api.rest.petstore.url}")
public interface PetApiClient extends PetApi {

}
