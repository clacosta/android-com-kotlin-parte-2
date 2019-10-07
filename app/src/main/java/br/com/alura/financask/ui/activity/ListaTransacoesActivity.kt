package br.com.alura.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alura.financask.R
import br.com.alura.financask.model.Tipo
import br.com.alura.financask.model.Transacao
import br.com.alura.financask.ui.adapter.ListaTrasacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes: List<Transacao> = trasacoesDeExemplo()
        configuraLista(transacoes)
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