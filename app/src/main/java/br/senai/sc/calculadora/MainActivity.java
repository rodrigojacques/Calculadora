package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String operador = "";
    private String primeiroNumero = "";
    private String segundoNumero = "";
    int resultado;
    int n1;
    int n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minha Calculadora");
        display = findViewById(R.id.tv_display);
    }

    public void onClickBtn0(View v) {
        atualizarNumeroDigitado("0");
        atualizarDisplay("0");
    }

    public void onClickBtn1(View v) {
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");
    }

    public void onClickBtn2(View v) {
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickBtn3(View v) {
        atualizarNumeroDigitado("3");
        atualizarDisplay("3");
    }

    public void onClickBtn4(View v) {
        atualizarNumeroDigitado("4");
        atualizarDisplay("4");
    }

    public void onClickBtn5(View v) {
        atualizarNumeroDigitado("5");
        atualizarDisplay("5");
    }

    public void onClickBtn6(View v) {
        atualizarNumeroDigitado("6");
        atualizarDisplay("6");
    }

    public void onClickBtn7(View v) {
        atualizarNumeroDigitado("7");
        atualizarDisplay("7");
    }

    public void onClickBtn8(View v) {
        atualizarNumeroDigitado("8");
        atualizarDisplay("8");
    }

    public void onClickBtn9(View v) {
        atualizarNumeroDigitado("9");
        atualizarDisplay("9");
    }



    public void onClickBtnAdicao(View v) {
        operador = "+";
        atualizarDisplay("+");
    }

    public void onClickBtnSubtracao(View v) {
        operador = "-";
        atualizarDisplay("-");
    }

    public void onClickBtnMultiplicacao(View v) {
        operador = "*";
        atualizarDisplay("*");
    }

    public void onClickBtnDivisao(View v) {
        operador = "/";
        atualizarDisplay("/");
    }

    public void onClickBtnIgual(View v){

        if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()) {
            n1 = Integer.parseInt(primeiroNumero);
            n2 = Integer.parseInt(segundoNumero);

            if (operador.equals("+")) {
                resultado = n1 + n2;
            }
            if (operador.equals("-")) {
                resultado = n1 - n2;
            }
            if (operador.equals("*")) {
                resultado = n1 * n2;
            }
            if (operador.equals("/")) {
                if (n1 == 0 || n2 == 0) {
                    Toast.makeText(MainActivity.this, "[ERRO] não é possível dividir por 0!", Toast.LENGTH_LONG).show();
                } else {
                    resultado = n1 / n2;
                }
            }
            display.setText(String.valueOf(resultado));
            operador = "";
            primeiroNumero = String.valueOf(resultado);
            segundoNumero = "";
            resultado = 0;
        }else{
            Toast.makeText(MainActivity.this, "Nenhuma operação solicitada", Toast.LENGTH_LONG).show();
        }

    }

    public void onClickBtnReset(View v){
        operador = "";
        primeiroNumero = "";
        segundoNumero = "";
        resultado = 0;
        n1 = 0;
        n2 = 0;
        display.setText("");
    }

    public void atualizarDisplay(String txt) {
        String txtDisplay = display.getText().toString();
        txtDisplay = txtDisplay + txt;
        display.setText(txtDisplay);

    }

    public void atualizarNumeroDigitado(String numero) {
        if (operador.isEmpty()) {
            primeiroNumero = primeiroNumero + numero;
        } else {
            segundoNumero = segundoNumero + numero;
        }

    }

}