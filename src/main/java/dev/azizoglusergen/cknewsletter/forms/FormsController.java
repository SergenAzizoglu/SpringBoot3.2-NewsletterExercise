package dev.azizoglusergen.cknewsletter.forms;

import dev.azizoglusergen.cknewsletter.ConvertKitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/forms")
public class FormsController {
    private static final Logger log = LoggerFactory.getLogger(FormsController.class);
    private ConvertKitProperties ckProps;
    private final RestClient restClient;

    public FormsController(ConvertKitProperties ckProps) {
        this.ckProps = ckProps;
        this.restClient = RestClient.create(ckProps.url());
    }

    @PostMapping("/subscribe")
    ResponseEntity<String> subscribe(@RequestBody SubscriberRequest subscriberRequest) {
        var body = new SubscriberRequest(subscriberRequest.email(), subscriberRequest.formId(), ckProps.apiKey());
        log.info("subscribe: {}", body);
        var response = restClient.post()
                .uri("/forms/585858/subscribe")
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .toEntity(String.class);
        log.info("subscribe: {}", response);

        return response;
    }
}
