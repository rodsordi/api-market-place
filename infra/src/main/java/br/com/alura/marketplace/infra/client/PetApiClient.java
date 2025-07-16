package br.com.alura.marketplace.infra.client;

import com.petstore.api.PetApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PetApiClient", url = "${api.rest.petstore.url}")
public interface PetApiClient extends PetApi {

}
