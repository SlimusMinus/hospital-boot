package aston.group86.hospitalboot.service;

import org.springframework.web.client.RestTemplate;

public class WireMockService {

  private final RestTemplate restTemplate;
  private final String baseUrl;

  public WireMockService(RestTemplate restTemplate, String baseUrl) {
    this.restTemplate = restTemplate;
    this.baseUrl = baseUrl;
  }

  public String getUserName(int userId) {
    return restTemplate.getForObject(baseUrl + "/users/" + userId, String.class);
  }
}
