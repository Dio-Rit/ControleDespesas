package entidade;

import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class BancoTest {

    @Test
    public void testarConexao() {
        assertNotEquals(null, Apoio.ConexaoBD.getInstance().getConnection());
    }
}
