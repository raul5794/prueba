package com.example.Consumir.Nasa.API.Controller;

import com.example.Consumir.Nasa.API.Entity.Astro;
import com.example.Consumir.Nasa.API.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class AstroWastro {

    @Autowired
    public ApiService apiService;

    @GetMapping("/buscar")
    public ResponseEntity<Astro> defaultUrl(){
        Astro as = this.apiService.buscar();
        return new ResponseEntity<Astro>(as, HttpStatus.OK);
    }
@GetMapping("/lista")
    public ResponseEntity<List<Astro>> devolverFechas(@RequestParam String d1,@RequestParam String d2 ) throws ParseException {
        List<Astro> as= this.apiService.buscarFechas(d1,d2);
        return new ResponseEntity<List<Astro>>(as,HttpStatus.OK);
    }
}

