package br.com.bandtec.projetotestes3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe Candidato")
class CandidatoTest {

  @Test
  @DisplayName("Entidade Candidato está anotada corretamente")
  void anotacoesClasse() {
    Class classe = Candidato.class;

    Annotation[] entities = classe.getDeclaredAnnotationsByType(Entity.class);
    assertEquals(1, entities.length);

    // ou
    assertTrue(classe.isAnnotationPresent(Entity.class), "Não está anotada com @Entity");

    Table table = (Table) classe.getDeclaredAnnotation(Table.class);
    assertNotNull(table);

    assertEquals("tbl_candidato", table.name());
  }

  @Test
  @DisplayName("Atributo nome está anotado corretamente")
  void anotacoesClasseNome() throws NoSuchFieldException {
    Class classe = Candidato.class;

    Column column = classe.getDeclaredField("nome").getDeclaredAnnotation(Column.class);
    assertNotNull(column, "nome deve estar anotado com @Column");

    assertFalse(column.nullable(), "O nullable da Column deve ser false");
    assertEquals(30, column.length(), "O length da Column deve ser 30");
  }

  @Test
  @DisplayName("Atributo votos está anotado corretamente")
  void anotacoesClasseVotos() throws NoSuchFieldException {
    Class classe = Candidato.class;

    Field votos = classe.getDeclaredField("votos");
    Min min = votos.getDeclaredAnnotation(Min.class);

    assertNotNull(min, "votos deve estar anotado com @Min");
    assertEquals(min.value(), 0, "valor de votos ser 0");
  }
}