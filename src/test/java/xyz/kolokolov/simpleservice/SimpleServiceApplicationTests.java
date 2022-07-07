package xyz.kolokolov.simpleservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Hello, world!", responseEntity.getBody());

    }

    @Test
    void multipleRequestsTest() throws ExecutionException, InterruptedException {
        List<Callable<ResponseEntity<String>>> tasks = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            tasks.add(helloRequest());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(tasks);

        Future<ResponseEntity<String>> submit = Executors
                .newSingleThreadExecutor().submit(helloRequest());

        assertEquals("Hello 100 times", submit.get().getBody());
    }

    private Callable<ResponseEntity<String>> helloRequest(){
        return () -> restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
    }

}
