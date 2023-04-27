package springbootmigrations.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUser() throws Exception{
        UserRequest request = new UserRequest();
        request.setName("pepe");
        request.setEmail("pepe@gmail.com");
        request.setAge(19);

        mockMvc.perform(
                post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpect(status().isOk())
                .andExpect(content().string("user created"));

    }


    @Test
    public void testInvalidData() throws Exception{
        UserRequest request = new UserRequest();
        request.setName("");
        request.setEmail("invalid email");
        request.setAge(15);
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                ).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors", hasSize(3)));
             //   .andExpect(jsonPath("$.errors[1]", is("name:the name is required")))
             //   .andExpect(jsonPath("$.errors[0]", is("age:must be greater than or equal to 18")))
             //   .andExpect(jsonPath("$.errors[2]", is("email:must be a valid email address"))
    }

}
