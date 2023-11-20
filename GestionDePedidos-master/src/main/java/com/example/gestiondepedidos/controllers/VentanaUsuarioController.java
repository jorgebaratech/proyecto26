package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.Main;
import com.example.gestiondepedidos.domain.pedido.Pedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador de la ventana de usuario en la aplicación de gestión de pedidos.
 * Esta clase gestiona la interfaz de usuario para mostrar los pedidos del usuario y permite al usuario cerrar sesión.
 */
public class VentanaUsuarioController implements Initializable {
    @javafx.fxml.FXML
    private Button btnCerrarSesion;

    private ObservableList<Pedido> pedidosObservable;
    @javafx.fxml.FXML
    private TableView<Pedido> tablausuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> idusuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> pedidousuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> fechausuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> usuariousuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> totalusuario;
    @javafx.fxml.FXML
    private Button btnNuevo;

    /**
     * Constructor de la clase VentanaUsuarioController.
     */
    public VentanaUsuarioController(){}

    /**
     * Inicializa la interfaz de usuario y carga los pedidos del usuario actual.
     *
     * @param url             Ubicación relativa del archivo FXML.
     * @param resourceBundle  Recursos utilizados para la inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idusuario.setCellValueFactory((fila)->{
            String id = String.valueOf((fila.getValue().getId()));
            return new SimpleStringProperty(id);
        });
        this.fechausuario.setCellValueFactory((fila)->{
            String fecha = String.valueOf((fila.getValue().getFecha()));
            return new SimpleStringProperty(fecha);
        });
        this.pedidousuario.setCellValueFactory((fila) -> {
            String codigoPedido = fila.getValue().getCodigo();
            return new SimpleStringProperty(codigoPedido);
        });
        this.usuariousuario.setCellValueFactory((fila) -> {
            String usuarioId = String.valueOf(fila.getValue().getUsuario());
            return new SimpleStringProperty(usuarioId);
        });
        this.totalusuario.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        this.pedidosObservable = FXCollections.observableArrayList();
        PedidoDAOImp pedidoDAOImp = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(pedidoDAOImp.loadAll(Sesion.getUsuario().getId()));
        this.pedidosObservable.addAll(Sesion.getPedidos());
        this.tablausuario.setItems(this.pedidosObservable);
        this.tablausuario.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            this.seleccionarPedido(this.tablausuario.getSelectionModel().getSelectedItem());
        });
    }

    /**
     * Maneja la selección de un com.example.gestiondepedidos.domain.pedido.pedido en la tabla y carga los detalles del com.example.gestiondepedidos.domain.pedido.pedido seleccionado.
     *
     * @param pedido Pedido seleccionado.
     */
    private void seleccionarPedido(Pedido pedido) {
        Sesion.setPedido(pedido);
        Sesion.setPos(this.tablausuario.getSelectionModel().getSelectedIndex());
        Main.loadFXMLDetalles("ventana-com.example.gestiondepedidos.domain.pedido.pedido.fxml");
    }

    @javafx.fxml.FXML
    public void closeSession(ActionEvent actionEvent) {
        Sesion.setUsuario(null);
        Main.loadFXMLLogin("login.fxml");
    }

    @javafx.fxml.FXML
    public void NewPedido(ActionEvent actionEvent) {
    }
}