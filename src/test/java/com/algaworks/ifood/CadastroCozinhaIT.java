package com.algaworks.ifood;

import static org.assertj.core.api.Assertions.assertThat;


import com.algaworks.ifood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.ifood.domain.exception.EntidadeEmUsoException;
import com.algaworks.ifood.domain.model.Cozinha;
import com.algaworks.ifood.domain.service.CadastroCozinhaService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.validation.ConstraintViolationException;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaIT {

// necessario baixar biblioteca inserindo dependencia assured

    @LocalServerPort
    private int port;

    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas(){
        //vai dar mais detalhes sobre o erro quando falhar o teste
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.given()
                .basePath("/cozinhas")
                .port(port)
                .accept(ContentType.JSON)
        .when()
                .get()
        .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveConter4Cozinhas_QuandoConsultarCozinhas(){
        //vai dar mais detalhes sobre o erro quando falhar o teste
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.given()
                .basePath("/cozinhas")
                .port(port)
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .body("", Matchers.hasSize(4))
                .body("nome", Matchers.hasItems("Tailandesa", "Indiana"));

    }

}