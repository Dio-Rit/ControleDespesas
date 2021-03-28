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

/**
 *
 * @author yNot
 */
public class PessoaDAO implements IDAO_T<Pessoa> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(Pessoa o) {
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
                return "Erro ao inserir";
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro salvar pessoa = " + e);
            return e.toString();
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

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE pessoa "
                    + "SET x = 'Inativo' "
                    + "WHERE id = " + id;

            int resultado = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir pessoa = " + e);
            return e.toString();
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
                    + "WHERE id = " + id;

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

}
