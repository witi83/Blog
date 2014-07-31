import java.net.*;
import java.nio.file.*;
import java.util.Collections;

public class Main {
	public static void main(String... args) throws Exception {
		URI uri = Main.class.getResource("test.txt").toURI();
		System.out.printf("uri: %s%n", uri);

		workaround(uri);
		bug(uri);
	}

	static void workaround(URI uri) throws Exception {
		String[] array = uri.toString().split("!");
		
		try (FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), Collections.emptyMap())) {
			Path path = fs.getPath(array[1]);
			byte[] bytes = Files.readAllBytes(path);
			System.out.println(new String(bytes));
		}
	}
	
	static void bug(URI uri) throws Exception {
		Path path = Paths.get(uri);
		byte[] bytes = Files.readAllBytes(path);
		System.out.println(new String(bytes));
	}
}