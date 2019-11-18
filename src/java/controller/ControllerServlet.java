package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

public class ControllerServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        usuarioDAO = new UsuarioDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/novo":
                    mostrarFormularioNovo(request, response);
                    break;
                case "/inserir":
                    inserir(request, response);
                    break;
                case "/deletar":
                    deletar(request, response);
                    break;
                case "/editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "/atualizar":
                    atualizar(request, response);
                    break;
                case "/index":
                    listarTodosUsuarios(request, response);
                    break;
                case "/":
                    listarTodosUsuarios(request, response);
                    break;
                default:
                    listarTodosUsuarios(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listarTodosUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuario> listaUsuarios = usuarioDAO.listaTodosUsuarios();
        request.setAttribute("listaUsuarios", listaUsuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioNovo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("FormUsuario.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioDAO.buscarPorId(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FormUsuario.jsp");
        request.setAttribute("usuario", usuario);
        dispatcher.forward(request, response);

    }

    private void inserir(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cidade = request.getParameter("cidade");

        Integer usuario_id = usuarioDAO.buscarIdUltimoUsuario() + 1;
        Usuario usuario = new Usuario(usuario_id, nome, email, cidade);
        boolean adicionou = usuarioDAO.inserir(usuario);
        response.sendRedirect("listar");
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("usuario_id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cidade = request.getParameter("cidade");
        Usuario usuario = new Usuario(Integer.parseInt(id), nome, email, cidade);
        usuarioDAO.atualizar(usuario);
        response.sendRedirect("listar");
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario(id);
        usuarioDAO.deletar(usuario);
        response.sendRedirect("listar");

    }
}
