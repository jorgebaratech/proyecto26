package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.Main;
import com.example.gestiondepedidos.domain.usuario.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador de la ventana de inicio de sesión en la aplicación de gestión de pedidos.
 * Esta clase gestiona la interfaz de usuario para permitir a los usuarios iniciar sesión y acceder a la aplicación.
 */
public class LoginController implements Serializable {

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Button txtEntrar;
    @FXML
    private Label info;

    /**
     * Constructor de la clase LoginController.
     */
    public LoginController() {
    }

    /**
     * Inicializa la interfaz de usuario de inicio de sesión.
     *
     * @param url            Ubicación relativa del archivo FXML.
     * @param resourceBundle Recursos utilizados para la inicialización.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Maneja el proceso de inicio de sesión cuando el usuario presiona el botón "Iniciar sesión".
     *
     * @param actionEvent Evento de acción que desencadena el inicio de sesión.
     */
    @Deprecated
    public void btnlogin(ActionEvent actionEvent) {
        String user = txtCorreo.getText();
        String password = txtPassword.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());
        //Coger usuario y contraseña y comprobarlos para pasar o no
        try {
            Usuario usuario = usuarioDAOImp.loadUser(user, password);
            Sesion.setUsuario(usuario);
            Main.loadFXMLUsuario("ventana-usuario.fxml");
        } catch (Exception e) {
            info.setText("Datos incorrectos, vuelva a introducirlos");
            info.setTextFill(Color.RED);
            throw new RuntimeException(e);
        }
    }

}

