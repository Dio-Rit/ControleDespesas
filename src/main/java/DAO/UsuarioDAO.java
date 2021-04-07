/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Apoio.ConexaoBD;
import Apoio.IDAO_T;
import Entidade.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class UsuarioDAO implements IDAO_T<Usuario> {

    ResultSet resultadoQ = null;

    public static String MD5(String s) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

    public boolean logar(String login, String senha) {
        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM usuario "
                    + "WHERE login = '" + login + "' "
                    + "AND senha = '" + senha + "' "
                    + "AND x = 'A';";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                String newLogin = resultadoQ.getString("login");
                String newSenha = resultadoQ.getString("senha");

                if (login.equals(newLogin) && senha.equals(newSenha)) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao realizar o login = " + e);
        }
        return false;
    }

    public boolean salvar1(Usuario o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO usuario VALUES "
                    + "(DEFAULT, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getLogin() + "',"
                    + "'" + o.getSenha() + "',"
                    + "'" + "A" + "'"
                    + ")";

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                //return "Erro ao inserir";
                return false;
            } else {
                //return null;
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro salvar usuário = " + e);
            //return e.toString();
            return false;
        }
    }

    @Override
    public String atualizar(Usuario o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario "
                    + "SET nome = '" + o.getNome() + "', "
                    + "login = '" + o.getLogin() + "', "
                    + "senha = '" + o.getSenha() + "' "
                    + "WHERE id = " + o.getId();

            int resultado = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuario = " + e);
            return e.toString();
        }
    }

    public boolean excluir1(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario "
                    + "SET x = 'I' "
                    + "WHERE id_usuario = " + id;

            int resultado = st.executeUpdate(sql);

            //return null;
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Usuário = " + e);
            //return e.toString();
            return false;
        }
    }

    @Override
    public Usuario consultarId(int id) {
        Usuario usu = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM usuario "
                    + "WHERE id_usuario = " + id;

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                usu = new Usuario();

                usu.setId(id);
                usu.setNome(resultadoQ.getString("nome"));
                usu.setLogin(resultadoQ.getString("login"));
                usu.setSenha(resultadoQ.getString("senha"));
            }

        } catch (Exception e) {
            System.out.println("Erro consultar usuario = " + e);
        }

        return usu;
    }

    public ArrayList<Usuario> consultarTodos() {

        ArrayList<Usuario> usuario = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * "
                    + "from "
                    + "usuario "
                    + "order by nome";
            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Usuario c = new Usuario();
                c.setId(resultado.getInt("id_usuario"));
                c.setNome(resultado.getString("nome"));
                c.setLogin(resultado.getString("login"));
                c.setSenha(resultado.getString("senha"));
                c.setX(resultado.getString("x"));

                usuario.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Usuario: " + e);
        }

        return usuario;
    }

    public int ultimoID() {
        int x = 0;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select max(id_usuario) "
                    + "from "
                    + "usuario ";

            ResultSet resultado = st.executeQuery(sql);
            resultado.next();
            x = resultado.getInt("max");

        } catch (Exception e) {
            System.out.println("Erro ao consultar id: " + e);
        }

        return x;
    }

    @Override
    public String salvar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
