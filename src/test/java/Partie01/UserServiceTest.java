package Partie01;

import org.example.Partie01.User;
import org.example.Partie01.UserRepository;
import org.example.Partie01.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.example.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        UserRepository mockRepo = mock(UserRepository.class);
        User expectedUser = new User(1L, "manal");
        when(mockRepo.findUserById(1L)).thenReturn(expectedUser);

        UserService userService = new UserService(mockRepo);
        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("manal", result.getName());
        verify(mockRepo).findUserById(1L);
    }
}
