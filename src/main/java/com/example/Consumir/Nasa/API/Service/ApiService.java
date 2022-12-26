package com.example.Consumir.Nasa.API.Service;



import com.example.Consumir.Nasa.API.Entity.Astro;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient.Builder webCBuilder){
        this.webClient = webCBuilder.baseUrl("https://api.nasa.gov/planetary/apod?api_key=i4lhRgp9rzfVZjYLbENSbc8ycLcbrOt58ShFVfHU").build();

    }

    public Astro buscar(){
       return this.webClient.get().retrieve().bodyToMono(Astro.class).block();
    }

    public List<Astro> buscarFechas(String d1, String d2){
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("start_date",d1)
                        .queryParam("end_date",d2)
                        .build())
                .retrieve().bodyToFlux(Astro.class).collectList().block();
    }

    public List<Astro> listarCantidad(String cantidad){
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .path("/")
                .queryParam("count",cantidad)
                .build())
                .retrieve()
                .bodyToFlux(Astro.class)
                .collectList()
                .block();
    }
}
