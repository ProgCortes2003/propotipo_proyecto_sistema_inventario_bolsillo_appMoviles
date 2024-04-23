import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirebaseAuthViewModel : ViewModel() {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    val currentUser = mutableStateOf<FirebaseUser?>(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            auth.addAuthStateListener { auth ->
                currentUser.value = auth.currentUser
            }
        }
    }
}