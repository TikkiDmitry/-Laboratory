package com.example.lab2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class HelloController {

    double result;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_res;

    @FXML
    private Button btn_res2;

    @FXML
    private Button btn_res3;

    @FXML
    private Button btn_reset;

    @FXML
    private Button btn_reset2;

    @FXML
    private Button btn_reset3;

    @FXML
    private TextField input_a;

    @FXML
    private TextField input_a1;

    @FXML
    private TextField input_a3;

    @FXML
    private TextField input_b;

    @FXML
    private TextField input_b1;

    @FXML
    private TextField input_b3;

    @FXML
    private TextField input_m;

    @FXML
    private TextField input_n;

    @FXML
    private TextField input_x;

    @FXML
    private Label s_res;

    @FXML
    private Label x_res;

    @FXML
    private Label x_res2;

    @FXML
    private Label y_res;

    @FXML
    private Label war_1;

    @FXML
    private Label war_2;

    @FXML
    private Label war_3;

    @FXML
    void initialize() {
        // Кнопка рассчёта согласно формуле 1
        btn_res.setOnAction(event -> {
            if (!(input_a.getText().length()==0) && !(input_b.getText().length()==0)) {
                try {
                    double v = Double.parseDouble(input_a.getText());
                    double v1 = Double.parseDouble(input_b.getText());
                    double x = Math.atan(v + v1) + (1 / Math.tan(v - v1));
                    x_res.setText("X = " + x);
                    y_res.setText("Y = " + ((Math.pow(Math.sin(Math.pow(v, 3)), 2)) + Math.pow(Math.cos(v1), 2) + Math.sin(Math.pow(x, 2))));
                } catch (NumberFormatException e) {
                    btn_res.isDisabled();
                }
            }else {
                // Появление подсказки на 2 секунды
                war_1.setVisible(true);
                PauseTransition delay = new PauseTransition(Duration.seconds(2));   // заставка запустится на 3 секунды
                delay.setOnFinished(event1 -> {
                    war_1.setVisible(false);
                });
                delay.play();
            }
        });
        // Кнопки сброса, очищение полей
        btn_reset.setOnAction(event -> {
            input_a.clear();
            input_b.clear();
            x_res.setText("");
            y_res.setText("");
        });
        btn_reset2.setOnAction(event -> {
            input_a1.clear();
            input_b1.clear();
            x_res2.setText("");
        });
        btn_reset3.setOnAction(event -> {
            input_a3.clear();
            input_b3.clear();
            input_m.clear();
            input_n.clear();
            input_x.clear();
            s_res.setText("");

        });
        // Кнопка рассчёта согласно формуле 2
        btn_res2.setOnAction(event -> {
            if (!(input_a1.getText().length()==0) && !(input_b1.getText().length()==0)) {
                try {
                    double k = Double.parseDouble(input_a1.getText());
                    double x = Double.parseDouble(input_b1.getText());
                    if (k == 1) {
                        result = Math.sin(Math.abs(k*x));
                        x_res2.setText("Y = " + result);
                    }
                    if (k == 2) {
                        result = Math.cos(Math.abs(k*x));
                        x_res2.setText("Y = " + result);
                    }
                    if (k == 3) {
                        result = Math.sqrt(Math.abs(k * Math.pow(x, 2) + 1));
                        x_res2.setText("Y = " + result);
                    }
                    if (k > 3) {
                        result = k + Math.pow(x, 2);
                        x_res2.setText("Y = " + result);
                    }
                } catch (NumberFormatException e) {
                    btn_res2.isDisabled();
                }
            }else {
                // Появление подсказки на 2 секунды
                war_2.setVisible(true);
                PauseTransition delay = new PauseTransition(Duration.seconds(2));   // заставка запустится на 3 секунды
                delay.setOnFinished(event1 -> {
                    war_2.setVisible(false);
                });
                delay.play();
            }
        });
        // Расчёт по формуле 3
        btn_res3.setOnAction(event -> {
            if (!(input_a3.getText().length()==0) && !(input_b3.getText().length()==0) && !(input_x.getText().length()==0) && !(input_n.getText().length()==0) && !(input_m.getText().length()==0)) {
                try {
                    double a = Double.parseDouble(input_a3.getText());
                    double b = Double.parseDouble(input_b3.getText());
                    double x = Double.parseDouble(input_x.getText());
                    double n = Double.parseDouble(input_n.getText());
                    double m = Double.parseDouble(input_m.getText());
                    double mn = 0;
                    for (double i = m; i <= n; i++) {
                        mn += ((Math.pow(-1, i)) * ((a + x * i) / (b + x * i)));
                    }
                    double res = a + (b * mn);
                    s_res.setText("S = " + res);
                } catch (NumberFormatException e) {
                    btn_res3.isDisabled();
                }
            }else {
                // Появление подсказки на 2 секунды
                war_3.setVisible(true);
                PauseTransition delay = new PauseTransition(Duration.seconds(2));   // заставка запустится на 3 секунды
                delay.setOnFinished(event1 -> {
                    war_3.setVisible(false);
                });
                delay.play();
            }
        });
    }

}
