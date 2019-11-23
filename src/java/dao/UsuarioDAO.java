package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table usuario in the database.
 *
 * @author www.codejava.net
 *
 */
public class UsuarioDAO {

    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;
    private Connection jdbcConnection;

    public UsuarioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (usuario_id, nome, email, cidade) VALUES (?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, usuario.getUsuario_id());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getEmail());
        statement.setString(4, usuario.getCidade());

        boolean adicionou = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return adicionou;
    }

    public List<Usuario> listaTodosUsuarios() throws SQLException {
        List<Usuario> listUsuario = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("usuario_id");
            String nome = resultSet.getString("nome");
            String email = resultSet.getString("email");
            String cidade = resultSet.getString("cidade");

            Usuario usuario = new Usuario(id, nome, email, cidade);
            listUsuario.add(usuario);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listUsuario;
    }

    public Integer buscarIdUltimoUsuario() throws SQLException {
        Integer idUsuario = 0;
        String sql = "SELECT * FROM usuario order by usuario_id DESC limit 1";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            idUsuario = resultSet.getInt("usuario_id");
        }
        
        resultSet.close();
        statement.close();

        disconnect();
        
        return idUsuario;
    }

    public boolean deletar(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuario where usuario_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, usuario.getUsuario_id());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, email = ?, cidade = ?";
        sql += " WHERE usuario_id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getCidade());
        statement.setInt(4, usuario.getUsuario_id());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Usuario buscarPorId(int id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE usuario_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String email = resultSet.getString("email");
            String cidade = resultSet.getString("cidade");

            usuario = new Usuario(id, nome, email, cidade);
        }

        resultSet.close();
        statement.close();

        return usuario;
    }
}
