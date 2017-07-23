package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

  final FileChooser fileChooser = new FileChooser();

  @FXML
  private Button someButton;

  @FXML
  private TextField someTextField;

  @FXML
  private TableView tableView;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    tableView.getColumns().clear();
    someButton.setDisable(true);
  }

  @FXML
  protected void handleChooseFileAction(ActionEvent event) {
    Node sourceNode = (Node) event.getSource();
    File file = fileChooser.showOpenDialog(sourceNode.getScene().getWindow());
    if (file != null) {
      someTextField.setText(file.getAbsolutePath());
      someButton.setDisable(false);
    }
  }

  @FXML
  protected void handleSomeAction(ActionEvent event) {
    someTextField.setText("Do something here");
  }
}
