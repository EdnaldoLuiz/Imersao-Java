package br.com.imersaojava.javaapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

  @Autowired
  private LinguagemRepository repositorio;

  @GetMapping(value = "/linguagem")
  public List<Linguagem> obterLinguagem() {
    List<Linguagem> linguagem = repositorio.findAll();
    return linguagem;
  }

  @PostMapping(value = "/linguagem")
  public Linguagem enviarLinguagem(@RequestBody Linguagem linguagem) {
    Linguagem linguagemSalva = repositorio.save(linguagem);
    return linguagemSalva;
  }

}
