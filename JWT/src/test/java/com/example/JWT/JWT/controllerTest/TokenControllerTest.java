package com.example.JWT.JWT.controllerTest;
import com.example.JWT.JWT.controller.TokenController;
import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.model.Role;
import com.example.JWT.JWT.service.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class TokenControllerTest {

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private TokenController tokenController;

    JwtModel jwtModel;

    @Test
    void testGetRecord() {
        // Arrange
        List<JwtModel> mockJwtModels = Arrays.asList(new JwtModel());
        when(tokenService.recordGet()).thenReturn(mockJwtModels);

        // Act
        List<JwtModel> result = tokenController.getRecord();

        // Assert
        assertEquals(mockJwtModels, result);
        verify(tokenService, times(1)).recordGet();
    }

    @Test
    void testGet()
    {
        ResponseEntity<String> response=tokenController.showData();
        assertEquals("Hello",response.getBody());
    }
    @Test
    void testSaveRecord() {
        JwtModel jwtModel = new JwtModel(1, "test@gmail.com", "Test", "K", "password", Role.USER);
        when(tokenService.recordSave(jwtModel)).thenReturn(jwtModel);

        JwtModel result = tokenController.saveRecord(jwtModel);
        verify(tokenService, times(1)).recordSave(jwtModel);
        assertEquals(jwtModel, result);
    }

    @Test
    void testUpdate()
    {
        Integer id=1;
        JwtModel jwtModel1=new JwtModel(1,"deepsi@mail.com","Deepsi","G","123",Role.USER);
        System.out.println("Expected: " + jwtModel1);
        when(tokenService.recordUpdate(id,jwtModel1)).thenReturn(jwtModel1);

        JwtModel result=tokenService.recordUpdate(id,jwtModel1);
        System.out.println("Actual: " + result);
        assertEquals(jwtModel1,result);
    }

    @Test
    void testDeleteById()
    {
        Integer id=1;
        String expected="Successfully Deleted";
        System.out.println("Expected: " + expected);
        when(tokenService.recordDelete(id)).thenReturn(expected);

        String actual=tokenController.deleteData(id);
        System.out.println("Actual: " + actual);
        assertEquals(expected,actual);
    }
    @Test
    void testSave()
    {
        jwtModel=new JwtModel(1,"deepsi@gmail.com","Deepsi","R","123",Role.USER);
        when(tokenService.recordSave(jwtModel)).thenReturn(jwtModel);

        JwtModel actual=tokenService.recordSave(jwtModel);
        //when(tokenController.saveRecord(actual)).thenReturn(jwtModel);

        assertEquals(jwtModel,actual);
    }
    @Test
    void testDeleteAll() {
        String expected=tokenService.deleteAll();
        when(tokenService.deleteAll()).thenReturn(expected);
        System.out.println("Expected: " + expected);

        String actual=tokenController.deleteAll();
        when(tokenController.deleteAll()).thenReturn(actual);
        System.out.println("Actual: " + actual);

        assertEquals(expected,actual);
    }

    @Test
    void testUpdateRecord()
    {
        jwtModel=new JwtModel(1,"deepsi@gmail.com","Deepsi","R","123",Role.USER);
        Integer id=1;
        when(tokenService.recordUpdate(1,jwtModel)).thenReturn(jwtModel);
        System.out.println("Expected: " + jwtModel);

        JwtModel jwtModel1=new JwtModel(1,"deepsi@gmail.com","Deepsi","R","123",Role.USER);
        when(tokenController.updateRecord(id,jwtModel1)).thenReturn(jwtModel1);
        System.out.println("Actual: " + jwtModel1);

        assertEquals(jwtModel,jwtModel1);

    }
}

