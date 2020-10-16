package br.com.bandtec.projetojpa3.controladores;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownloadController {

  @GetMapping("1")
  public ResponseEntity get1() {
    return ResponseEntity.ok(1);
  }

  @GetMapping(value = "pdf-loko", produces = {"application/pdf"})
  @ResponseBody
  public ResponseEntity getpdf() {
    return ResponseEntity.ok("só que não");
  }

  @GetMapping(value = "/zip-loko", produces = {"application/x-7z-compressed"})
  @ResponseBody
  public ResponseEntity getZip() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=lokao.zip");

    return new ResponseEntity("Conteúdo Zip fake", headers, HttpStatus.OK);
  }
}
