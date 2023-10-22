package com.example.tapprimerparcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// (CC) Ponemos que reciba el contexto
class Adapter(val context: Context) : ListAdapter<Comida, Adapter.ViewHolder>(DiffCallBack) {
    // (FF) Creamos el holder para apretar sobre el equipo
    lateinit var onItemClickListener: (Comida) -> Unit



    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.tv_nombre)
        private val dificultad: TextView = view.findViewById(R.id.tv_dificultad)
        private val pais: TextView = view.findViewById(R.id.tv_pais)
        private val imagencomida: ImageView = view.findViewById(R.id.iv_imagen_comida)
        private val bandera: ImageView = view.findViewById(R.id.iv_bandera)


        fun bind (comida: Comida) {
            nombre.text = comida.nombre
            dificultad.text=comida.dificultad.toString()
            pais.text= comida.pais.toString()

            val imagen = when (comida.pais) {
                Pais.ARGENTINA -> R.drawable.arg
                Pais.BRASIL -> R.drawable.bra
                Pais.CHILE -> R.drawable.chil
                Pais.COLOMBIA -> R.drawable.col
                Pais.EEUU -> R.drawable.eeuu
                Pais.PARAGUAY -> R.drawable.par
                Pais.PERU -> R.drawable.peru
                Pais.MEXICO -> R.drawable.mex
            }
            //(BB) Ponemos la imagen
            bandera.setImageResource(imagen)

            //(DD)Importamos la libreria glide, le ponemos el contexto
            Glide.with(context).load(comida.logo).into(imagencomida)

            //(FF) A cada vista cada vez que hacemos click, se bindea con el equipo que elegimos
            view.setOnClickListener {
                onItemClickListener(comida)
            }
        }
    }

    //Creamos un elemento segun el formato
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        //Cada una de las listas va a inflar a los itemlist. Cada vez que se crea un VH, lo haga con los elementos de Itemlist
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        //Retorna la vista
        return ViewHolder(view)
    }

    //Mandamos a determinada posicion, un Pokemon
    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        //Le decimos que cada plantilla va a tener un Pokemon. Le mandamos un Pokemon segun la posicion donde esté
        val comida = getItem(position)
        //Bindeamos el Pokemon encontrado
        holder.bind(comida)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Comida>() {
        override fun areItemsTheSame(oldItem: Comida, newItem: Comida): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comida, newItem: Comida): Boolean {
            return oldItem == newItem
        }
    }
}


//(CC) EN EL MANIFEST PONER:
// <uses-permission android:name="android.permission.INTERNET"/>