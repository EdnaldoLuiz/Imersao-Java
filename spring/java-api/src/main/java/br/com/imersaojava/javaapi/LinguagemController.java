package br.com.imersaojava.javaapi;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

  private List<Linguagem> linguagens = List.of(
    new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),

    new Linguagem("Python", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png", 2)
  );

  @GetMapping(value = "/linguagem")
  public List<Linguagem> obterLinguagem() {
    List<Linguagem> linguagens = null;
    return linguagens;
  }

}
