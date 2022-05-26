package br.espm.cambio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioResource {

    private List<Moeda> moedas = new ArrayList<>();

    @Autowired
    private MoedaService moedaService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello ESPM";
    }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda() {
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findMoedaBySimbolo(simbolo);
    }

    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda) {
        moedaService.create(moeda);
    }
    
}
