package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText edNome, edCpf;
    private Button btCadastrar, btVoltar;
    private TextView tvClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        btCadastrar = findViewById(R.id.btCadastrar);
        btVoltar = findViewById(R.id.btVoltar);
        tvClientes = findViewById(R.id.tvClientes);

        atualizarCliente();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente(edNome,edCpf);
                atualizarCliente();
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(MainActivity.class);
            }
        });
    }

    public void salvarCliente(TextView nome, TextView cpf){
        Cliente cliente = new Cliente();
        if(!nome.getText().toString().isEmpty() && !cpf.getText().toString().isEmpty()){
            cliente.setNome(nome.getText().toString());
            cliente.setCpf(cpf.getText().toString());
            Controller.getInstance().salvarCliente(cliente);
        }
        else if(nome.getText().toString().isEmpty()){
            nome.setError("O nome está vazio!");
        }
        else if(cpf.getText().toString().isEmpty()){
            cpf.setError("O CPF está vazio!");
        }
    }

    public void atualizarCliente(){
        String texto = "";
        for(Cliente cl : Controller.getInstance().retornarCliente()){
            texto += "Nome: " + cl.getNome() + "\nCPF: " + cl.getCpf() + "\n";
        }
        tvClientes.setText(texto);
    }

    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}