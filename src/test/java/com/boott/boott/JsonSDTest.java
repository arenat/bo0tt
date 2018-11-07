package com.boott.boott;

import com.boott.boott.entities.People;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.*;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class JsonSDTest {

    private static People details = new People();
    static {
        details.setId(1);
        details.setFullName("hp");
        details.setJobTitle("hp_test");
    }

    @Autowired
    private JacksonTester<People> json;

    @Test
    public void testSerialize() throws Exception {
        Resource resource = new ClassPathResource("json/people.json");
        String json = null;
        try {
            json = StreamUtils.copyToString( resource.getInputStream(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(this.json.write(details)).isEqualToJson(json);
    }

    @Test
    public void testDeserialize() throws Exception {
        Resource resource = new ClassPathResource("json/people.json");
        String json = StreamUtils.copyToString( resource.getInputStream(), Charset.defaultCharset());
        assertThat(this.json.parse(json))
                .isEqualTo(details);
    }
}
