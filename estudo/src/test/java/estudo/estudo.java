package estudo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;

public class estudo {

	public static void main(String[] args) throws IOException {
		System.out.println("Rafael");
		Teste();
	}

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/config.properties");
		props.load(file);
		return props;

	}

	@Before
	public static void Teste() throws IOException {
		String Caminho;
		Properties prop = getProp();
		Caminho = prop.getProperty("caminho");
		System.setProperty("webdriver.chrome.drive", Caminho);
		System.out.println(Caminho);
	}

}
