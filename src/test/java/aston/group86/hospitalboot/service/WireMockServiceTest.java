package aston.group86.hospitalboot.service;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

@WireMockTest(httpPort = 8080)
class WireMockServiceTest {

  private WireMockService wIreMockService;

  @BeforeEach
  void init(){
    wIreMockService = new WireMockService(new RestTemplate(), "http://localhost:8080");
  }

  @Test
  void getUserName() {

     // Настраиваем мок-сервер WireMock
    stubFor(get(urlEqualTo("/users/1"))
        .willReturn(aResponse()
            .withHeader("Content-Type", "application/json")
            .withBody("{\"name\": \"John Doe\"}")
            .withStatus(200)));

    // Вызываем метод, который делает HTTP-запрос
    String response = wIreMockService.getUserName(1);

    // Проверяем, что ответ соответствует ожидаемому
    assertEquals("{\"name\": \"John Doe\"}", response);

    // Проверяем, что был выполнен правильный HTTP-запрос
    verify(getRequestedFor(urlEqualTo("/users/1")));
  }
}