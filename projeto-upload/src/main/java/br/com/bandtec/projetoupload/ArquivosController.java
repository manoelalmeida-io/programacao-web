package br.com.bandtec.projetoupload;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/arquivos")
public class ArquivosController {

  @PostMapping("/simples")
  public ResponseEntity enviar(@RequestBody byte[] conteudoArquivo) throws IOException {
    Path path = Paths.get("nova-leitura.txt");
    Files.write(path, conteudoArquivo);
    return ResponseEntity.created(null).build();
  }

  @PostMapping("/completo")
  public ResponseEntity enviar(@RequestParam("arquivo") MultipartFile arquivo) throws IOException {
    if (arquivo.isEmpty()) {
      return ResponseEntity.badRequest().body("Arquivo não enviado!");
    }

    System.out.println("Recebendo um arquivo de tipo: " + arquivo.getContentType());

    byte[] conteudo = arquivo.getBytes();
    Path path = Paths.get(arquivo.getOriginalFilename());
    Files.write(path, conteudo);

    return ResponseEntity.created(null).build();
  }
}
