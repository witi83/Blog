package de.witi.xbmc.jfx

import javafx.fxml.FXML
import javafx.scene.control.{Button, Label, TextField}
import javafx.event.ActionEvent
import javafx.stage.Stage

class LoginController {
  @FXML
  var urlField: TextField = _
  @FXML
  var msgLabel: Label = _
  @FXML
  var button: Button = _

  def connect(event: ActionEvent) {
    button.setDisable(true)
  }
}