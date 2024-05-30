package kr.ac.kopo.inputuserinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var textName: EditText
    lateinit var textEmail: EditText
    lateinit var btnDlg: Button
    lateinit var dlgEditName: EditText
    lateinit var dlgEditEmail: EditText
    lateinit var textToast: TextView
    lateinit var dlgView: View
    lateinit var toastView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "사용자 정보 입력"
        textName = findViewById<EditText>(R.id.textName)
        textEmail = findViewById<EditText>(R.id.textEmail)
        btnDlg = findViewById<Button>(R.id.btnDlg)

        btnDlg.setOnClickListener {
            dlgView = View.inflate(this@MainActivity, R.layout.dialog, null)
            var dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("사용자 정보 입력 (수정)")
            dlgEditName = dlgView.findViewById<EditText>(R.id.editName)
            dlgEditEmail = dlgView.findViewById<EditText>(R.id.editEmail)
            dlgEditName.text = textName.text
            dlgEditEmail.text = textEmail.text
            dialog.setView(dlgView)
            dialog.setIcon(R.drawable.logo)
            dialog.setPositiveButton("확인") { dialogL, which ->
                textName.text = dlgEditName.text
                textEmail.text = dlgEditEmail.text
            }
            dialog.setNegativeButton("취소") { dialogL, which ->
                toastView = View.inflate(this@MainActivity, R.layout.toast, null)
                var toast = Toast(this@MainActivity)
                toast.view = toastView
                toast.duration = Toast.LENGTH_LONG
                toast.show()
            }
            dialog.show()
        }
    }
}