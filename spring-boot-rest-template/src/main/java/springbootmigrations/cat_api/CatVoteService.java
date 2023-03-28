package springbootmigrations.cat_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springbootmigrations.cat_api.dto.VoteRequest;
import springbootmigrations.cat_api.dto.VoteResponse;

@Service
public class CatVoteService {

    @Value("${catapi.apikey}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public CatVoteService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public VoteResponse createVote(String imageId, int value, String subId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apiKey);

        VoteRequest request = new VoteRequest();
        request.setImageId(imageId);
        request.setSubId(subId);
        request.setValue(value);


        HttpEntity<VoteRequest> entity = new HttpEntity<>(request, headers);

        String url = "https://api.thecatapi.com/v1/votes";

        VoteResponse response = restTemplate.exchange(url, HttpMethod.POST, entity, VoteResponse.class).getBody();

        return response;
    }

}
