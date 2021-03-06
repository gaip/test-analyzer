package testanalyzer.examples.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MultipleTestsWithMultipleExpects {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test1() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void test2() throws Exception {
		mockMvc.perform(get("/"));
	}

	@Test
	public void test3() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(is("Hello, World")));
	}

	@Test
	public void test4() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(is("Hello, World")));

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(is("Hello, World")));
	}
	
	@Test
	public void test5() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(is("Hello, World")));
		assertTrue(false);
	}
}
