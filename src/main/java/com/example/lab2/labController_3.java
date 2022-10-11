package com.example.lab2;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class labController_3 {

    // Билдеры для работы с двоичным кодом
    StringBuilder builder1 = new StringBuilder();
    StringBuilder builder2 = new StringBuilder();
    StringBuilder builder3 = new StringBuilder();

    // Список для записи длины введённых символово в двоичном коде
    ArrayList<Integer> arrayList = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_decode;

    @FXML
    private Button btn_encode;

    @FXML
    private TextArea encoded_text;

    @FXML
    private TextArea text_input;

    @FXML
    private TextArea text_output;

    @FXML
    void initialize() {

        // Очищение всех полей
        btn_clear.setOnAction(event -> {
            text_input.clear();
            encoded_text.clear();
            text_output.clear();
        });

        // Шифрование текста
        btn_encode.setOnAction(event -> {
            // Очищение билдеров и списка для корректной работы при новых вводимых данных
            builder1.setLength(0);
            builder3.setLength(0);
            builder2.setLength(0);
            arrayList.clear();

            // Константы для метода гаммирования
            int A = 5;
            int C = 3;
            int b = 5;
            int M = (int) Math.pow(2, b);
            int t = 0;
            int T;

            if (text_input.getText().length() > 0) {

                for (int i = 0; i < text_input.getText().length(); i++) {
                    char text_inp = text_input.getText().charAt(i);
                    builder1.append(Integer.toBinaryString(text_inp));        // Перевод в двоичный код и добавление в билдер1 введённого текста
                    arrayList.add(Integer.toBinaryString(text_inp).length()); // Перевод в двоичный код и добавление в список длины каждого символа
                    T = (A * t + C) % M;                                      // Формула для гамма шифра
                    t += 1;
                    //System.out.println(T);
                    builder2.append(Integer.toBinaryString(T));               // Перевод в двоичный код и добавление в билдер2 полученных данных из формулы

                    // Условие добавления 0 в билдер2 при разных длинах билдеров
                    if (Integer.toBinaryString(text_inp).length() > Integer.toBinaryString(T).length()) {
                        for (int j = 0; j < Integer.toBinaryString(text_inp).length() - Integer.toBinaryString(T).length(); j++) {
                            builder2.append("0");
                    }
                }

                }
//                System.out.println(builder1);
//                System.out.println(builder2);
//                System.out.println("---------------------------");
//                System.out.println(arrayList.toString());

                // Шифрование путём сложения исходного текста и гамма шифра в двоичном коде
                for (int k = 0; k < builder1.length(); k++) {
                    if (String.valueOf(builder1.charAt(k)).contains("0") && String.valueOf(builder2.charAt(k)).contains("0")) {
                        builder3.append("0");
                    } else if (String.valueOf(builder1.charAt(k)).contains("1") && String.valueOf(builder2.charAt(k)).contains("1")) {
                        builder3.append("0");
                    }
                    else {
                        builder3.append("1");
                    }
                }
                //System.out.println(builder3);
                encoded_text.setText(builder3.toString());

            }
        });
        // Дешифрование путём сложения зашифрованного текста и гамма шифра в двоичном коде
        btn_decode.setOnAction(event -> {
            builder1.setLength(0);
            StringBuilder builder4 = new StringBuilder();
            for (int i = 0; i < builder3.length(); i++) {
                if (String.valueOf(builder3.charAt(i)).contains("0") && String.valueOf(builder2.charAt(i)).contains("0")) {
                    builder1.append("0");
                } else if (String.valueOf(builder3.charAt(i)).contains("1") && String.valueOf(builder2.charAt(i)).contains("1")) {
                    builder1.append("0");
                }else {
                    builder1.append("1");
                }
            }
            //System.out.println(arrayList.size());

            // Перевод двоичного кода в текст
            for (int j = 0; j < arrayList.size(); j++) {
                char a = (char) Integer.parseInt(builder1.substring(0, arrayList.get(j)), 2);
                //System.out.println(builder1.substring(0, arrayList.get(j)));
                builder4.append(a);
                builder1.delete(0, arrayList.get(j));
            }
            text_output.setText(builder4.toString());
        });
    }

}

