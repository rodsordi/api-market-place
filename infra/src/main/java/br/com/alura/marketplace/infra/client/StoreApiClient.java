package br.com.alura.marketplace.infra.client;

import com.petstore.api.StoreApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "StoreApiClient", url = "${external-api.rest.petstore.url}")
public interface StoreApiClient extends StoreApi {

}
