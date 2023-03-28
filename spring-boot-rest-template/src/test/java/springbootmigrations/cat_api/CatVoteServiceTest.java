package springbootmigrations.cat_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.client.MockRestServiceServer;
import springbootmigrations.cat_api.dto.VoteResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(CatVoteService.class)
@TestPropertySource(properties = {"catapi.apikey=testkey"})
class CatVoteServiceTest {

    @Autowired
    private CatVoteService catVoteService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void testCreateVote() {
        server
                .expect(requestTo("https://api.thecatapi.com/v1/votes"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(header("x-api-key", "testkey"))
                .andRespond(withSuccess("{\n" +
                        "    \"message\": \"SUCCESS\",\n" +
                        "    \"id\": 988557,\n" +
                        "    \"image_id\": \"123456\",\n" +
                        "    \"sub_id\": \"xxaa\",\n" +
                        "    \"value\": 1,\n" +
                        "    \"country_code\": \"CO\"\n" +
                        "}", MediaType.APPLICATION_JSON));


        VoteResponse voteResponse = catVoteService.createVote("123456", 1, "xxaa");

        assertThat(voteResponse).isNotNull();
        assertThat(voteResponse.getImageId()).isEqualTo("123456");
        assertThat(voteResponse.getValue()).isEqualTo(1);
        assertThat(voteResponse.getSubId()).isEqualTo("xxaa");
    }

}