package com.example.libraryApplication;



import com.example.libraryApplication.Controller.MainController;
import com.example.libraryApplication.Model.Book;
import com.example.libraryApplication.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
class ContollerMockTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryService libraryService;

    @Test
    void testAddBook() throws Exception {
        Book book = new Book("Title1", "Author1", true);

        mockMvc.perform(post("/api/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Title1\",\"author\":\"Author1\",\"isbn\":\"ISBN1\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllBooks() throws Exception {
        List<Book> books = Arrays.asList(
                new Book("Title1", "Author1", false),
                new Book("Title2", "Author2", true)
        );
        when(libraryService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"))
                .andExpect(jsonPath("$[1].title").value("Title2"));
    }

    @Test
    void testGetBookById() throws Exception {
        String id = "1";
        Book book = new Book("Title1", "Author1", true);
        when(libraryService.getBookById(id)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title1"));
    }

    @Test
    void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/DeleteBook/1"))
                .andExpect(status().isOk());
    }
}
