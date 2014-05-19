package de.witi.xbmc.jfx

import javafx.application.{Platform, Application}
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

object App {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[App], args: _*)
  }
}

class App extends Application {
  override def start(primaryStage: Stage) {
    val loader = new FXMLLoader(classOf[App].getResource("/login.fxml"))
    val root = loader.load().asInstanceOf[Parent]
    primaryStage.setTitle("JavaFX GUI example in Scala")
    primaryStage.setScene(new Scene(root))
    primaryStage.show()
  }
}