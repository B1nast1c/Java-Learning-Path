package pe.edu.ulasalle.utest.test.mockito.dobles;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pe.edu.ulasalle.utest.utils.SenderEmail;
import pe.edu.ulasalle.utest.utils.SenderSms;
import pe.edu.ulasalle.utest.utils.UtilText;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilText {

    @Spy
    @InjectMocks
    private UtilText util;

    @Mock
    private SenderEmail senderEmail;

    @Mock
    private SenderSms senderSms;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEncriptar() {
        // ejemplo de Stub
        String texto = "hello UTEST";
        Mockito.when(util.encriptar(texto)).thenReturn("abcdefghijklmnopqrstu");
        assertEquals("abcdefghijklmnopqrstu", util.encriptar(texto));
    }

    @Test
    void testEnviarEmail() {
        String email = "myfriend@gmail.com";
        String text = "Hi My friend, Regards.";
        Mockito.when(senderEmail.sendEmail(email, text)).thenReturn(true); //Supuesto del retorno del uso del "MOCK"
        assertEquals(true, util.enviarEmail(email, text)); //LA PRUEBA ES CORRECTA PQ EN LA LINEA ANTERIOR SE EMULA EL COMPORTAMIENTO DE LA LLLAMADA AL SENDEREMAIL CONTENIDO DENTRO DE UTILS
    }

    @Test
    void testEnviarSms() {
        String number = "123465789";
        String text = "Hola";
        Mockito.when(senderSms.sendSms(number, text)).thenReturn(true);
        assertEquals(true, util.enviarSms(number, text));
    }

    @Test
    void testADate() {
        String dateStr = "2020/06/18";
        int hora = 9;
        int minuto = 21;
        util.aDate(dateStr, hora, minuto);
        Mockito.verify(util).aCalendar(dateStr, "yyyy/MM/dd", hora, minuto);
    }

}

