package coder.mtk.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.PhantomReference
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var dbReference: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase
    private var userId : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseDatabase= FirebaseDatabase.getInstance()
        dbReference = firebaseDatabase.getReference("users")

        userId = dbReference.push().key.toString()

        btnAdd.setOnClickListener{

            if (TextUtils.isEmpty(userId)){
                var name = edtUserName.text.toString()
                var phone : String = edtUserPhoneNumber.text.toString()

                createUser(name,phone)

                edtUserName.setText("")
                edtUserPhoneNumber.setText("")
            }else{
                Log.d("userId>>>>>>",userId.toString())
                updateUser(edtUserName.text.toString(),edtUserPhoneNumber.text.toString())
            }

        }



    }

     fun createUser (name: String, mobile: String){
        val user = User (name,mobile)
        dbReference.child(userId).setValue(user)
    }
    fun updateUser (nameUpdate : String , moblieUpdate : String){
        if (!TextUtils.isEmpty(nameUpdate)){
            dbReference.child(userId).child(nameUpdate).setValue(nameUpdate)
        }
            if (!TextUtils.isEmpty(moblieUpdate)){
                dbReference.child(userId).child(moblieUpdate).setValue(moblieUpdate)
            }

            dbReference.child(userId).addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
//                var user = snapshot.getValue(User::class.java)
//
//                edtUserName.setText(user?.name)
//                edtUserPhoneNumber.setText(user?.mobile)
            }

        })
    }
}