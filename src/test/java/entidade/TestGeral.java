package entidade;

import DAO.CategoriaDAO;
import Entidade.Pessoa;
import Entidade.Categoria;
import Entidade.Usuario;
import DAO.PessoaDAO;
import DAO.UsuarioDAO;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGeral {

    Categoria categoria = new Categoria();
    Pessoa pessoa = new Pessoa();
    Usuario usuario = new Usuario();

    CategoriaDAO cd = new CategoriaDAO();
    PessoaDAO pd = new PessoaDAO();
    UsuarioDAO ud = new UsuarioDAO();

    int lastCategoria = 0;
    int lastPessoa = 1;
    int lastUsuario = 0;

    @Test
    public void testaCadastroPessoa() {
        pessoa.setNome("TestePessoa");
        pessoa.setCpf("Teste");
        pessoa.setX("A");
        assertEquals(true, pd.salvar1(pessoa));
    }

    @Test
    public void testaCadastroCategoria() {
        categoria.setNome("TesteCategoria");
        categoria.setDescricao("Tste");
        categoria.setX("A");
        assertEquals(true, cd.salvar1(categoria));
    }

    @Test
    public void testaCadastroUsuario() {
        usuario.setNome("TesteUsuario");
        usuario.setLogin("Teste");
        usuario.setSenha("Teste");
        usuario.setX("A");
        assertEquals(true, ud.salvar1(usuario));
    }

    @Test
    public void TesteExcluirPessoa() {
        boolean x = false;
        lastPessoa = pd.ultimoID();
        x = pd.excluir1(lastPessoa);
        assertEquals(true, x);
    }

    @Test
    public void TesteExcluirCategoria() {
        boolean x = false;
        lastCategoria = cd.ultimoID();
        x = cd.excluir1(lastCategoria);
        assertEquals(true, x);
    }

    @Test
    public void TesteExcluirUsuario() {
        boolean x = false;
        lastUsuario = ud.ultimoID();
        x = ud.excluir1(lastUsuario);
        assertEquals(true, x);
    }

    @Test
    public void testaUltimoIdPessoa() {
        lastPessoa = pd.ultimoID();
        assertEquals(1, lastPessoa);
    }

    @Test
    public void testaUltimoIdCategoria() {
        lastCategoria = cd.ultimoID();
        assertEquals(1, lastCategoria);
    }

    @Test
    public void testaUltimoIdUsuario() {
        lastUsuario = ud.ultimoID();
        assertEquals(1, lastUsuario);
    }

}
