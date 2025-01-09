package com.algaworks.algafood;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.service.AtivacaoClienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
        log.info("Chamando primeiro controller");

    }

    @GetMapping("/hello")
    public String hello(){

        Cliente joao = new Cliente("Joao", "Joao@email.com", "312312312321");
        ativacaoClienteService.ativar(joao);
        return "Hello";
    }
}
