package reobchichorro.inf311.pratica01a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double valor1, valor2;
    double resultado;
    Button mais, menos, vezes, divisao;

    EditText valor1_input, valor2_input;
    TextView resultado_output;

    private void calcular(int op) {
        valor1 = Double.valueOf(valor1_input.getText().toString());
        valor2 = Double.valueOf(valor2_input.getText().toString());

        switch(op) {
            case 1:
                resultado = valor1 + valor2;
                break;
            case 2:
                resultado = valor1 - valor2;
                break;
            case 3:
                resultado = valor1 * valor2;
                break;
            case 4:
                if(Math.abs(valor2) < 1e-15)
                    resultado = Double.MAX_VALUE;
                else
                    resultado = valor1 / valor2;
                break;
        }

        if(resultado != Double.MAX_VALUE)
            resultado_output.setText("O resultado é "+formatar(resultado));
        else
            resultado_output.setText("Erro: divisão por 0 ou por número muito pequeno. Realize outra operação.");
    }

    public String formatar(double num)
    {
        if(num == (long) num)
            return String.format("%d",(long)num);
        else
            return String.format("%s",num);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1_input = (EditText) findViewById(R.id.valor1n);
        valor2_input = (EditText) findViewById(R.id.valor2n);
        resultado_output = (TextView) findViewById(R.id.resultadot);

        mais = (Button) findViewById(R.id.op_mais);
        menos = (Button) findViewById(R.id.op_menos);
        vezes = (Button) findViewById(R.id.op_vezes);
        divisao = (Button) findViewById(R.id.op_divisao);

        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(1);
            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(2);
            }
        });
        vezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(3);
            }
        });
        divisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(4);
            }
        });
    }
}