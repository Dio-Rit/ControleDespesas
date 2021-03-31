/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Apoio.ConexaoBD;
import Apoio.IDAO_T;
import Entidade.Pessoa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yNot
 */
public class PessoaDAO implements IDAO_T<Pessoa> {

    ResultSet resultadoQ = null;

    public boolean salvar1(Pessoa o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO pessoa VALUES "
                    + "(DEFAULT, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getCpf() + "',"
                    + "'" + "A" + "'"
                    + ")";

            System.out.println("Sql: " + sql);

            int resultado = st.executeUpdate(sql);

            if (resultado == 0) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro salvar pessoa = " + e);
            //return e.toString();
            return false;
        }
    }

    @Override
    public String atualizar(Pessoa o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE pessoa "
                    + "SET nome = '" + o.getNome() + "', "
                    + "descricao = '" + o.getCpf() + "', "
                    + "WHERE id = " + o.getId_pessoa();

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar pessoa = " + e);
            return e.toString();
        }
    }

    
    public boolean excluir1(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            System.out.println(id);
            String sql = "UPDATE pessoa "
                    + "SET x = 'I' "
                    + "WHERE id_pessoa = " + id;

            int resultado = st.executeUpdate(sql);

            //return null;
            return true;
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir pessoa = " + e);
            //return e.toString();
            return false;
        }
    }

    @Override
    public Pessoa consultarId(int id) {
        Pessoa usu = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM pessoa "
                    + "WHERE id_pessoa = " + id;

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                usu = new Pessoa();

                usu.setId_pessoa(id);
                usu.setNome(resultadoQ.getString("nome"));
                usu.setCpf(resultadoQ.getString("cpf"));
            }

        } catch (Exception e) {
            System.out.println("Erro consultar pessoa = " + e);
        }

        return usu;
    }

    public ArrayList<Pessoa> consultarTodos() {

        ArrayList<Pessoa> usuario = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * "
                    + "from "
                    + "pessoa "
                    + "order by nome";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Pessoa c = new Pessoa();
                c.setId_pessoa(resultado.getInt("id_pessoa"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setX(resultado.getString("x"));

                usuario.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Pessoa: " + e);
        }

        return usuario;
    }

    public int ultimoID() {
        int x = 0;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select max(id_pessoa) "
                    + "from "
                    + "pessoa ";

            ResultSet resultado = st.executeQuery(sql);
            resultado.next();
            x = resultado.getInt("max");

        } catch (Exception e) {
            System.out.println("Erro ao consultar id: " + e);
        }

        return x;
    }

    @Override
    public String salvar(Pessoa o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
