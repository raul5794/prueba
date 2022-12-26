package com.example.Consumir.Nasa.API.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

@Service
public class ApiGatos {

    private  final WebClient webClient;

    public ApiGatos(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("https://placekitten.com/").build();
    }

    public byte[] gatos(String a, String b){
        return  this.webClient.get().uri("/{a}/{b}",a,b).retrieve().bodyToMono(byte[].class).block();
    }
}
