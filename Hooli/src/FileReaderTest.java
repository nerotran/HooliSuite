import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FileReaderTest {

	@Test
	void testReadAppFile() {
		ArrayList<Application> test = FileReader.readAppFile("ApplicationData.txt");
		assertEquals(test.get(0).toString(), "Name: Ping Pong Publisher: Java Platform: PC "
				+ "Description: Desc Price: 100.0 Link: https://www.google.com/ Released: ");
		assertEquals(test.get(1).toString(), "Name: Solitaire Publisher: Linux Platform: XBox "
				+ "Description: Desc Price: 200.0 Link: https://www.google.com/ Released: ");
		assertEquals(test.get(2).toString(), "Name: Tetris Publisher: Microsoft Platform: PC "
				+ "Description: Desc Price: 55.0 Link: https://www.google.com/ Released: ");
	}

}
