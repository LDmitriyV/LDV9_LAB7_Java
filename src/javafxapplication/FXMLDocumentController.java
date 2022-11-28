package javafxapplication;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button_Math;
    @FXML
    private Label label_a;
    @FXML
    private Label label_b;
    @FXML
    private Label label_x;
    @FXML
    private Label label_otvet;
    @FXML
    private TextField textField_A;
    @FXML
    private TextField textField_B;
    @FXML
    private TextField textField_X;
    @FXML
    private Label label_d;
    @FXML
    private TextField textField_D;
    @FXML
    private Button button_Clear;
    @FXML
    private Button button_Exit;

    static {
        // Установка формата вывода для java.util.logging.SimpleFormatter
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT [%4$-7s] %3$s - %5$s %n");

    }

    // Объявление логировцика типа org.apache.log4j.Logger
    static org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(FXMLDocumentController.class);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void buttonMathAction(ActionEvent event) {
        log4j.info("Start button action");
        double a = 0, b = 0, x= 0, y;
try {
            a = Double.parseDouble(textField_A.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            
            log4j.warn("Incorrect data!");
            
            textField_A.requestFocus();
            label_otvet.setText("В введенном значении A допущена ошибка");
            textField_A.setText("???");
            textField_B.setText("");
            textField_X.setText("");
            return;
        }
try {
            b = Double.parseDouble(textField_B.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_B.requestFocus();
            label_otvet.setText("В введенном значении B допущена ошибка");
            textField_B.setText("???");
            textField_X.setText("");
            textField_A.setText("");
            return;
        }
try {
            x = Double.parseDouble(textField_X.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            log4j.warn("Incorrect data!");
            textField_X.requestFocus();
            label_otvet.setText("В введенном значении X допущена ошибка");
            textField_X.setText("???");
            textField_A.setText("");
            textField_B.setText("");
            return;
        }

        if (x < 6) {
            y = a / x + b / x * x;
            //label_otvet.setText("Ответ: " + String.format("%.2f",y));
        } else {
            y = a * 2 * (x + b);
            //label_otvet.setText("Ответ: " + String.format("%.2f",y));
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            label_otvet.setText("Ответ: y = " + String.format("%.2f", y));
        } else {
            label_otvet.setText("Нет ответа");
            log4j.error("Error! Division by zero.");
        }
        log4j.info("End button action");
    }

    @FXML
    private void buttonClearAction(ActionEvent event) {
        log4j.info("Start Cleaning");
        label_otvet.setText("Ответ: ");
        textField_A.setText("");
        textField_B.setText("");
        textField_X.setText("");
        log4j.info("End Cleaning");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        log4j.info("End log4j");
        org.apache.log4j.LogManager.shutdown();
        System.exit(0);
    }

}
