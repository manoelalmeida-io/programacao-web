package br.com.bandtec.projetotestes2.controladores;

import br.com.bandtec.projetotestes2.entidades.Escola;
import br.com.bandtec.projetotestes2.repositorios.EscolaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EscolaController.class)
class EscolaControllerTest {

  @Autowired
  EscolaController controller;

  /* Injeta um MOCK e não um objeto real */
  @MockBean
  EscolaRepository repository;

  @Test
  @DisplayName("getTodos() deve trazer a lista certa e status 200")
  void getTodosCenario1() {
    // 1° uso de mock: um mock de Escolas para compor a lista
    List<Escola> escolas = Arrays.asList(Mockito.mock(Escola.class));

    // 2° uso de mock: nós ENSINAMOS o que o mock deve retornar
    Mockito.when(repository.findAll()).thenReturn(escolas);

    ResponseEntity resposta = controller.getTodos();
    assertEquals(200, resposta.getStatusCodeValue());
    assertEquals(escolas, resposta.getBody());
  }

  @Test
  @DisplayName("getTodos() não deve ter corpo e status 204")
  void getTodosCenario2() {
    List<Escola> escolas = new ArrayList<>();

    Mockito.when(repository.findAll()).thenReturn(escolas);

    ResponseEntity resposta = controller.getTodos();

    assertEquals(204, resposta.getStatusCodeValue());
    assertEquals(null, resposta.getBody());
  }

  @Test
  @DisplayName("getUm deve retornar 200 caso id exista")
  void getUmCenario1() {
    Integer id = 1;

    Escola escola = Mockito.mock(Escola.class);
    Mockito.when(repository.findById(id)).thenReturn(Optional.of(escola));

    ResponseEntity resposta = controller.getUm(id);

    assertEquals(200, resposta.getStatusCodeValue());
    assertEquals(escola, resposta.getBody());
  }

  @Test
  @DisplayName("getUm deve retornar 404 caso id não exista")
  void getUmCenario2() {
    Integer id = 3;

    Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

    ResponseEntity resposta = controller.getUm(id);

    assertEquals(404, resposta.getStatusCodeValue());
    assertEquals(null, resposta.getBody());
  }

  @Test
  @DisplayName("deleteUm() deve retornar 404 caso id inexistente")
  void deleteUmCenario1() {
    // o id aqui é um Dummy (tipo mais simples de dublê)
    Integer id = 51;

    // aqui ensinamos ao mock "repository" o que fazer
    Mockito.when(repository.existsById(id)).thenReturn(false);

    ResponseEntity resposta = controller.deleteUm(id);

    assertEquals(404, resposta.getStatusCodeValue());
    assertEquals(null, resposta.getBody());
  }

  @Test
  @DisplayName("deleteUm() deve retornar 200 caso id existe")
  void deleteUmCenario2() {
    Integer id = 30;

    Mockito.when(repository.existsById(id)).thenReturn(true);

    ResponseEntity resposta = controller.deleteUm(id);

    assertEquals(200, resposta.getStatusCodeValue());
    assertEquals(null, resposta.getBody());
  }

  @Test
  @DisplayName("buscar() deve retornar 200 caso encontre escolas com os parametros")
  void buscarCenario1() {
    Integer min = 100, max = 1000;

    List<Escola> escolas = Arrays.asList(Mockito.mock(Escola.class));

    Mockito.when(repository.findByAlunosBetween(min, max)).thenReturn(escolas);

    ResponseEntity resposta = controller.buscar(min, max);

    assertEquals(200, resposta.getStatusCodeValue());
    assertEquals(escolas, resposta.getBody());
  }

  @Test
  @DisplayName("buscar() deve retornar 204 caso não encontre escolas com os parametros")
  void buscarCenario2() {
    Integer min = 100, max = 1000;

    List<Escola> escolas = new ArrayList<>();

    Mockito.when(repository.findByAlunosBetween(min, max)).thenReturn(escolas);

    ResponseEntity resposta = controller.buscar(min, max);

    assertEquals(204, resposta.getStatusCodeValue());
    assertNull(resposta.getBody());
  }

  @Test
  @DisplayName("buscar() deve retornar 400 caso os parametros sejam invalidos")
  void buscarCenario3() {
    Integer min = -20, max = 1000;

    ResponseEntity resposta = controller.buscar(min, max);

    assertEquals(400, resposta.getStatusCodeValue());
    assertEquals("parâmetros inválidos", resposta.getBody());

    min = 10;
    max = -9;

    resposta = controller.buscar(min, max);

    assertEquals(400, resposta.getStatusCodeValue());
    assertEquals("parâmetros inválidos", resposta.getBody());
  }
}
