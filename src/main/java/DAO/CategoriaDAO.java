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
import java.util.ArrayList;

/**
 *
 * @author yNot
 */
public class CategoriaDAO implements IDAO_T<Categoria> {

    ResultSet resultadoQ = null;

    public boolean salvar1(Categoria o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO categoria VALUES "
                    + "(DEFAULT, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getDescricao() + "',"
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
            System.out.println("Erro salvar categoria = " + e);
            //return e.toString();
            return false;
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

            int resultado = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar categoria = " + e);
            return e.toString();
        }
    }

    public boolean excluir1(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE categoria "
                    + "SET x = 'I' "
                    + "WHERE id_categoria = " + id;

            int resultado = st.executeUpdate(sql);

            //return null;
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir categoria = " + e);
            //return e.toString();
            return false;
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
                    + "WHERE id_categoria = " + id;

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

    public ArrayList<Categoria> consultarTodos() {

        ArrayList<Categoria> usuario = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * "
                    + "from "
                    + "categoria "
                    + "order by nome";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(resultado.getInt("id_categoria"));
                c.setNome(resultado.getString("nome"));
                c.setDescricao(resultado.getString("descricao"));
                c.setX(resultado.getString("x"));

                usuario.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Categoria: " + e);
        }

        return usuario;
    }

    public int ultimoID() {
        int x = 0;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select max(id_categoria) "
                    + "from "
                    + "categoria ";

            ResultSet resultado = st.executeQuery(sql);
            resultado.next();
            x = resultado.getInt("max");

        } catch (Exception e) {
            System.out.println("Erro ao consultar id: " + e);
        }

        return x;
    }

    @Override
    public String salvar(Categoria o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
