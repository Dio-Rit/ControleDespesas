/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Apoio.ConexaoBD;
import Apoio.IDAO_T;
import Entidade.Categoria;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author yNot
 */
public class CategoriaDAO implements IDAO_T<Categoria> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(Categoria o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO categoria VALUES "
                    + "(DEFAULT, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getDescricao() + "',"
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
            System.out.println("Erro salvar categoria = " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Categoria o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE categoria "
                    + "SET nome = '" + o.getNome() + "', "
                    + "descricao = '" + o.getDescricao() + "', "
                    + "WHERE id = " + o.getId_categoria();

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar categoria = " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE categoria "
                    + "SET x = 'Inativo' "
                    + "WHERE id = " + id;

            int resultado = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir categoria = " + e);
            return e.toString();
        }
    }

    @Override
    public Categoria consultarId(int id) {
        Categoria usu = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM categoria "
                    + "WHERE id = " + id;

            System.out.println("Sql: " + sql);

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                usu = new Categoria();

                usu.setId_categoria(id);
                usu.setNome(resultadoQ.getString("nome"));
                usu.setDescricao(resultadoQ.getString("descricao"));
            }

        } catch (Exception e) {
            System.out.println("Erro consultar categoria = " + e);
        }

        return usu;
    }

}
