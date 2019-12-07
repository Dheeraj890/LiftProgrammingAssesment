package com.example.liftprogramming.adapter

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.liftprogramming.R
import com.example.liftprogramming.model.LiftModel


class LiftAdapter(val mContext:Context,val liftList: List<LiftModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_FIRST_VIEW = 1
    private val TYPE_ANOTHER = 2


    companion object{
        private var itemSelected= mutableListOf<LiftModel>()


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var view:Any

        if(viewType==TYPE_FIRST_VIEW) {


            view =
                LayoutInflater.from(parent.context).inflate(R.layout.layout_resource_first_view, parent, false)
            return ViewHolderForFirstView(view, mContext)
        }

        else
        {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.layout_recycle, parent, false)
            return ViewHolder(view, mContext)

        }

    }


    override fun getItemViewType(position: Int): Int {
        return if (position==0) {
            TYPE_FIRST_VIEW
        } else {
            TYPE_ANOTHER
        }
    }

    override fun getItemCount(): Int {


        return liftList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) === TYPE_FIRST_VIEW) {
            (holder as ViewHolderForFirstView).bindItems(liftList[position],position)
        } else {
            (holder as ViewHolder).bindItems(liftList[position],position)
        }
    }


    //the class is hodling the list view
    class ViewHolder(itemView: View,val context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(lift: LiftModel,pos:Int) {
            val textLiftUp = itemView.findViewById(R.id.textViewUp) as TextView
            val textLiftDown = itemView.findViewById(R.id.textViewDown) as TextView
            val imageLift = itemView.findViewById(R.id.imageView) as ImageView
            textLiftUp.text = "Lift Floor ${lift.liftUp}"
            textLiftDown.text = "Lift Floor ${lift.liftDown}"


            textLiftDown.setOnClickListener(View.OnClickListener {

                textLiftDown.setBackgroundResource(R.drawable.shape_layout_grey)
                LiftAdapter.itemSelected.add(lift)


            })


            textLiftUp.setOnClickListener(View.OnClickListener {

                textLiftUp.setBackgroundResource(R.drawable.shape_layout_grey)

                LiftAdapter.itemSelected.add(lift)


            })


        }




    }






    class ViewHolderForFirstView(itemView: View,val context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(lift: LiftModel,pos:Int) {
            val textLiftUp = itemView.findViewById(R.id.textViewUp) as TextView
            val textLiftDown = itemView.findViewById(R.id.textViewDown) as TextView
            val imageLift = itemView.findViewById(R.id.imageView) as ImageView
            textLiftUp.text = "Lift Floor ${lift.liftUp}"
            textLiftDown.text = "Lift Floor ${lift.liftDown}"


            textLiftDown.setOnClickListener(View.OnClickListener {

                textLiftDown.setBackgroundResource(R.drawable.shape_layout_grey)

                LiftAdapter.itemSelected.add(lift)

            })


            textLiftUp.setOnClickListener(View.OnClickListener {

                textLiftUp.setBackgroundResource(R.drawable.shape_layout_grey)


                LiftAdapter.itemSelected.add(lift)
            })

        }
    }


    fun getSelectedItem(): MutableList<LiftModel> {


        return itemSelected
    }



    fun clearItem() {

         itemSelected.clear()
    }
}