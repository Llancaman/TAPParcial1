package com.example.tapprimerparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvComidas: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //(bb) Acordarse de poner el id al rv en el xml
        rvComidas= findViewById(R.id.rv_comida)
        rvComidas.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvComidas.adapter=adapter
        //Creamos la funcion y que se cree apretando en rojo
        adapter.submitList(getListadoEquipos())
    }

    private fun getListadoEquipos(): MutableList<Comida>? {
        return mutableListOf(
            Comida(1,
                "Asado",
                6,
                Pais.ARGENTINA,
                "https://www.clarin.com/img/2022/03/07/0w2kcAVNO_1200x630__1.jpg",
                listOf(Ingredientes.CARNE, Ingredientes.ESPECIAS)
            ),
            Comida(2,
                "Feijoada",
                7,
                Pais.BRASIL,
                "https://imagenes.montevideo.com.uy/imgnoticias/201406/_W880_H495/452029.jpg",
                listOf(Ingredientes.CARNE, Ingredientes.VEGETALES)
            ),
            Comida(3,
                "Curanto",
                3,
                Pais.CHILE,
                "https://bichosdecampo.com/wp-content/uploads/2017/11/curanto-2.jpg",
                listOf(Ingredientes.VEGETALES)
            ),
            Comida(4,
                "Sancocho",
                5,
                Pais.COLOMBIA,
                "https://cdn.kiwilimon.com/brightcove/7752/7752.jpg",
                listOf(Ingredientes.VEGETALES)
            ),
            Comida(5,
                "Hot Dog",
                2,
                Pais.EEUU,
                "https://www.vvsupremo.com/wp-content/uploads/2016/02/900X570_Mexican-Style-Hot-Dogs.jpg",
                listOf(Ingredientes.PAN, Ingredientes.SALCHICHA)
            ),
            Comida(6,
                "Tacos",
                3,
                Pais.MEXICO,
                "https://www.onceuponachef.com/images/2023/08/Beef-Tacos.jpg",
                listOf(Ingredientes.HARINA, Ingredientes.CARNE)
            ),
            Comida(7,
                "Chipa",
                2,
                Pais.PARAGUAY,
                "https://s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2019/06/12154040/Chipa-polemica-Paraguay.jpg",
                listOf(Ingredientes.HARINA)
            ),
            Comida(8,
                "Ceviche",
                7,
                Pais.PERU,
                "https://www.infobae.com/new-resizer/6DTSLj1-aiae-nogutPc9oipMtk=/arc-anglerfish-arc2-prod-infobae/public/XHEHX7Q3RBEP7OGGC52732N2IU.jpg",
                listOf(Ingredientes.PESCADO)
            ))
    }

}