package com.software.listadecompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText campoProduto;
    EditText campoMarca;
    EditText campoQuantidade;

    Button botaoSalvar;

    List<Produto> dadosProdutos;
    ListView listagemProdutos;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById(R.id.campoProduto);
        campoMarca = findViewById(R.id.campoMarca);
        campoQuantidade = findViewById(R.id.campoQuantidade);
        listagemProdutos = findViewById(R.id.listaProdutos);

        botaoSalvar = findViewById(R.id.botaoSalvar);

        dadosProdutos = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dadosProdutos);

        listagemProdutos.setAdapter(adapter);
        acaoComponentes();
    }

    private void acaoComponentes() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produto = new Produto();

                produto.setNome(campoProduto.getText().toString());
                produto.setMarca(campoMarca.getText().toString());
                produto.setQuantidade(Integer.parseInt(campoQuantidade.getText().toString()));

                dadosProdutos.add(produto);
                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Produto Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}