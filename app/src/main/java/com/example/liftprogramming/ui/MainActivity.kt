package com.example.liftprogramming.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liftprogramming.R
import com.example.liftprogramming.adapter.LiftAdapter
import com.example.liftprogramming.model.LiftModel
import com.example.liftprogramming.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BasicActivity() {

    var viewModel: MainActivityViewModel? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var result: String = ""

    var adapter: LiftAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]


        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        viewModel?.getLiftList()?.observe(this, Observer<List<LiftModel>> { lift ->

            adapter = LiftAdapter(this, lift)

            recyclerView.adapter = adapter


        })
        viewModel?.loadList()



        button.setOnClickListener {


            processClick()

        }


    }

    private fun processClick() {



        val data = adapter?.getSelectedItem()

        if (data?.size!! > 0) {

            var sortedData = data.sortedWith(compareBy { it.liftDown })



            postView(recyclerView, sortedData.size, sortedData)



            adapter?.clearItem()


        } else {

            Toast.makeText(this, getString(R.string.toast_msg), Toast.LENGTH_SHORT).show()
        }



    }

    override fun onResume() {
        super.onResume()
    }


    fun postView(view: RecyclerView, size: Int, data: List<LiftModel>) {
        var counter: Int = 0


        val period: Long = 1500
        Timer().schedule(object : TimerTask() {
            override fun run() {


                if (counter > 0 && counter != size) {

                    deleteBack(view, counter - 1, data)
                }

                if (counter != size) {
                    val viewItem: View? =
                        view.getLayoutManager()?.findViewByPosition(data.get(counter++).id)
                    val icon: View? = viewItem?.findViewById(R.id.imageView)
                    icon?.setBackgroundResource(R.drawable.shape_lift_icon)
                    result += "${data.get(counter - 1).liftDown}->"


                } else {

                    cancel()


                    runOnUiThread(Runnable {


                        progressBar.visibility = View.VISIBLE
                        progressBar.postDelayed(Runnable {


                            val intent = Intent(applicationContext, ResultActivity::class.java)

                            intent.putExtra("value", result.dropLast(2))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)

                            startActivity(intent)


                        }, 2000)

                    })

                }

            }
        }, 0, period)


    }

    private fun deleteBack(view: RecyclerView, pos: Int, data: List<LiftModel>) {


        val viewItem: View? =
            view.getLayoutManager()?.findViewByPosition(data.get(pos).id)
        val icon: View? = viewItem?.findViewById(R.id.imageView)
        icon?.setBackgroundResource(R.drawable.shape_rect)


    }

    override fun onRestart() {
        super.onRestart()

        recreate()
    }
}
