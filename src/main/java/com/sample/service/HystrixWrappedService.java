package com.sample.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sample.conf.Application;
import com.sample.conf.HttpWebClient;
import com.sample.exception.IntegrationRuntimeException;

@Component
public class HystrixWrappedService {

  @Value("${HYSTRIX_TEST_URL:url_not_accessiable}")
  private String HYSTRIX_TEST_URL;

  @Autowired
  @Qualifier(Application.DEFAULT_REST_TEMPLATE)
  protected RestTemplate restTemplate;

  @HystrixCommand(groupKey = HttpWebClient.GROUP, commandKey = HttpWebClient.COMMAND_GET,
      threadPoolKey = HttpWebClient.THREAD_POOL_KEY,
      ignoreExceptions = {IntegrationRuntimeException.class})
  public String getContent() {
    try {
      ResponseEntity<String> responseEntity =
          restTemplate.exchange(HYSTRIX_TEST_URL, HttpMethod.GET, getHeadersEntity(), String.class);
      return responseEntity.getBody();
    } catch (HttpClientErrorException ex) {
      throw new IntegrationRuntimeException(
          "client exception, can be ingored for hystrix circuit breaker", ex);
    }
  }

  private HttpEntity<String> getHeadersEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>(headers);
    return entity;
  }
}
