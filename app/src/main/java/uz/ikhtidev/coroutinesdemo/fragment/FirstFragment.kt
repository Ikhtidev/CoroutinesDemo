package uz.ikhtidev.coroutinesdemo.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.*
import uz.ikhtidev.coroutinesdemo.R

class FirstFragment : Fragment() {

    private val scope = CoroutineScope(Dispatchers.IO + CoroutineName("MyScope"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

//        val job2 = scope.launch {
//            Log.d("MyCoroutine", this.coroutineContext.toString())
//            val job2 = launch {
//                Log.d("MyCoroutine", this.coroutineContext.toString())
//            }
//        }

//        GlobalScope.launch {
//            Log.d("MyCoroutine", this.coroutineContext.toString())
//            while (true){
//                delay(1000L)
//                Log.d("MyCoroutines", "Running...")
//            }
//        }

        lifecycleScope.launch {
            while (true){
                delay(1000L)
                Log.d("MyCoroutines", "Running...")
            }
        }

        view.findViewById<Button>(R.id.btnGo).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }

    override fun onPause() {
        Log.d("MyCoroutines", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("MyCoroutines", "onStop")
        super.onStop()
    }

    override fun onResume() {
        Log.d("MyCoroutines", "onResume")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d("MyCoroutines", "onDestroy")
        super.onDestroy()
    }
}