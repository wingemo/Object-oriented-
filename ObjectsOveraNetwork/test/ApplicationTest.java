import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ApplicationTest {
  @Test
  void testReadConfig() throws IOException {
    Properties config = Application.readConfig(Application.CONFIG_PATH);
    assertNotNull(config);
  }
}
