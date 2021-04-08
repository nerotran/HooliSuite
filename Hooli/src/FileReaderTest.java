import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileReaderTest {

	@Test
	void testReadAppFile() {
		Application[] test = FileReader.readAppFile("ApplicationData.txt");
		assertEquals(test[0].toString(), "Name: Ping Pong Publisher: Java Platform: PC "
				+ "Description: Desc Price: 100.0 Link: https://www.google.com/ Released: ");
		assertEquals(test[1].toString(), "Name: Solitaire Publisher: Linux Platform: XBox "
				+ "Description: Desc Price: 200.0 Link: https://www.google.com/ Released: ");
		assertEquals(test[2].toString(), "Name: Tetris Publisher: Microsoft Platform: PC "
				+ "Description: Desc Price: 55.0 Link: https://www.google.com/ Released: ");
	}

}
