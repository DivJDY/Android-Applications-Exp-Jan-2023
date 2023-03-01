package iterate.ai.aop

import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    fun displayToast(message:String){
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }
}