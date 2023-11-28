import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  
   
    @Test
    void testStudentInput_InvalidName() {
        ByteArrayInputStream in = new ByteArrayInputStream("1234\nJohn123\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.studentInput();

        System.setIn(System.in);
        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Invalid Input"));
    }

    @Test
    void testStudentInput_InvalidStream() {
        ByteArrayInputStream in = new ByteArrayInputStream("John Doe\n1234\n3\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.studentInput();

        System.setIn(System.in);
        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Invalid Input"));
    }

    @Test
    void testStudentInput_InvalidGender() {
        ByteArrayInputStream in = new ByteArrayInputStream("John Doe\n1234\n1\n4\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.studentInput();

        System.setIn(System.in);
        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Invalid Input"));
    }

    @Test
    void testStudentInput_InputMismatchException() {
        ByteArrayInputStream in = new ByteArrayInputStream("John Doe\nabcd\n1\n1\n1990\nAddis Ababa\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.studentInput();

        System.setIn(System.in);
        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Please Enter a number"));
    }

}
