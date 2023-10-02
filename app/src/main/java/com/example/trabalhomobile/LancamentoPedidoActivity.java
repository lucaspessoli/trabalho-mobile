package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class LancamentoPedidoActivity extends AppCompatActivity {

    private TextView tvItensAdicionados;
    private AutoCompleteTextView tvACCliente;
    private Spinner spItem, spItemPagar;
    private Button btAdicionarItem,btPagar,btVoltar;
    private RadioButton rbAVista,rbAPrazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_pedido);

        tvACCliente = findViewById(R.id.tvACCliente);
        tvItensAdicionados = findViewById(R.id.tvItensAdicionados);
        spItem = findViewById(R.id.spItem);
        spItemPagar = findViewById(R.id.spItemPagar);
        btAdicionarItem = findViewById(R.id.btAdicionarItem);
        btPagar = findViewById(R.id.btPagar);
        btVoltar =  findViewById(R.id.btVoltarMenuPedido);
        rbAVista = findViewById(R.id.rbAVista);
        rbAPrazo = findViewById(R.id.rbAPrazo);
        carregarItem();
        carregarListaClientes();

        btAdicionarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(MainActivity.class);
            }
        });
    }

    private void carregarListaClientes(){
        ArrayList<Cliente> listaClientes = Controller.getInstance().retornarCliente();
        String[] vetorClientes = new String[listaClientes.size() + 1];
        vetorClientes[0] = "";

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetorClientes[i + 1] = cliente.getNome();
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, vetorClientes);
        tvACCliente.setAdapter(adapter);
    }
    private void carregarItem(){
        ArrayList<Item> itens = Controller.getInstance().retornarItem();
        String[] vetorItem = new String[itens.size()];

        for(int i=0;i<itens.size();i++){
            Item item = itens.get(i);
            vetorItem[i] = item.getDescricaoItem();
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,vetorItem);
        spItem.setAdapter(adapter);
    }

    public void adicionarItemPedido(){
        Pedido pedido = new Pedido();
        String itemSelecionado = spItem.getSelectedItem().toString();

    }

    private void abrirActivity(Class<?> activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}