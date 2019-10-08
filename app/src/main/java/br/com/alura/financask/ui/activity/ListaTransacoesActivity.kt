package br.com.alura.financask.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.model.Tipo
import br.com.alura.financask.model.Transacao
import br.com.alura.financask.ui.ResumoView
import br.com.alura.financask.ui.adapter.ListaTrasacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes: List<Transacao> = trasacoesDeExemplo()
        configuraResumo(transacoes)
        configuraLista(transacoes)
        lista_transacoes_adiciona_receita.setOnClickListener {
            val view = window.decorView
            val viewCriada = LayoutInflater.from(this)
                .inflate(R.layout.form_transacao, view as ViewGroup, false)

            val ano = 2019
            val mes = 9
            val dia = 18

            val hoje = Calendar.getInstance()
            viewCriada.form_transacao_data.setText(hoje.formataParaBrasileiro())
            viewCriada.form_transacao_data.setOnClickListener {
                DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        var dataSelecionada = Calendar.getInstance()
                        dataSelecionada.set(year, month, dayOfMonth)
                        viewCriada.form_transacao_data.setText(dataSelecionada.formataParaBrasileiro())
                    }, ano, mes, dia).show()
            }

            AlertDialog.Builder(this)
                .setTitle(R.string.adiciona_despesa)
                .setView(viewCriada)
                .show()
        }
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.atualiza()
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTrasacoesAdapter(this, transacoes)
    }

    private fun trasacoesDeExemplo(): List<Transacao> {
        val transacoes: List<Transacao> = listOf(
            Transacao(
                valor = BigDecimal(20.5),
                categoria = "Almoço de final de semana",
                tipo = Tipo.DESPESA,
                data = Calendar.getInstance()
            ),
            Transacao(
                valor = BigDecimal(100.0),
                categoria = "Economia",
                tipo = Tipo.RECEITA
            ),
            Transacao(
                valor = BigDecimal(200.00),
                tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(500.0),
                categoria = "Prêmio",
                tipo = Tipo.RECEITA
            )
        )
        return transacoes
    }

}