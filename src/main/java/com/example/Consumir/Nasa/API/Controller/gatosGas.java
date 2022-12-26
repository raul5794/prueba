package com.example.Consumir.Nasa.API.Controller;

import com.example.Consumir.Nasa.API.Service.ApiGatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

@RestController
public class gatosGas {

    @Autowired
    public ApiGatos apiGatos;

    @RequestMapping("/gatos/{uno}/{dos}")
    public ResponseEntity<?> imagne(@PathVariable String uno, @PathVariable String dos){
        byte[] imagenData =this.apiGatos.gatos(uno,dos);
       return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(imagenData);
    }
}
