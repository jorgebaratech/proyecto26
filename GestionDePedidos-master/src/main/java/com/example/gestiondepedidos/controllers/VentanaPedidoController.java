package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.Main;
import com.example.gestiondepedidos.domain.item.Item;
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
 * Controlador de la ventana de detalles de com.example.gestiondepedidos.domain.pedido.pedido en la aplicación de gestión de pedidos.
 * Esta clase gestiona la interfaz de usuario para mostrar los detalles de un com.example.gestiondepedidos.domain.pedido.pedido y permite al usuario cerrar sesión o volver atrás.
 */
public class VentanaPedidoController implements Initializable {
    @javafx.fxml.FXML
    private Button btnCerrarSesion;

    private ObservableList<Item> observableListItem;
    @javafx.fxml.FXML
    private TableView tablapedidos;
    @javafx.fxml.FXML
    private TableColumn<Item, String> idpedidos;
    @javafx.fxml.FXML
    private TableColumn<Item, String> pedidopedidos;
    @javafx.fxml.FXML
    private TableColumn<Item, String> cantidadpedidos;
    @javafx.fxml.FXML
    private TableColumn<Item, String> productopedidos;
    @javafx.fxml.FXML
    private Button btnVolver;
    @javafx.fxml.FXML
    private Button btnNuevo;

    /**
     * Constructor de la clase VentanaPedidoController.
     */
    public VentanaPedidoController() {
    }

    /**
     * Inicializa la interfaz de usuario y carga los detalles del com.example.gestiondepedidos.domain.pedido.pedido seleccionado.
     *
     * @param url            Ubicación relativa del archivo FXML.
     * @param resourceBundle Recursos utilizados para la inicialización.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idpedidos.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });
        this.pedidopedidos.setCellValueFactory((fila) -> {
            String cPedido = fila.getValue().getCodigo();
            return new SimpleStringProperty(cPedido);
        });
        this.cantidadpedidos.setCellValueFactory((fila) -> {
            String cCantidad = String.valueOf(fila.getValue().getCantidad());
            return new SimpleStringProperty(cCantidad);
        });
        this.productopedidos.setCellValueFactory((fila) -> {
            String cProducto = String.valueOf(fila.getValue().getProduct_id().getNombre());
            return new SimpleStringProperty(cProducto);
        });

        this.observableListItem = FXCollections.observableArrayList();
        ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
        Sesion.setItems(itemDAOImp.loadAll(Sesion.getPedido().getCodigo()));
        this.observableListItem.addAll(Sesion.getItems());
        this.tablapedidos.setItems(this.observableListItem);
    }

    @Deprecated
    public void closeSession(ActionEvent actionEvent) {
        Sesion.setUsuario(null);
        Main.loadFXMLLogin("login.fxml");
    }

    @Deprecated
    public void volver(ActionEvent actionEvent) {
        Main.loadFXMLUsuario("ventana-usuario.fxml");
    }

    @javafx.fxml.FXML
    public void newPedido(ActionEvent actionEvent) {
    }
}
