package jp.suntech.s21037.myconstrainlayout;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{


    protected Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btSend = findViewById(R.id.btSend);
        Button btconfirm = findViewById(R.id.btConfirm);
        Button btCear=findViewById(R.id.btClear);
        HelloListener listener = new HelloListener();
        ButtonClickListener conlistener = new ButtonClickListener();
        ButtonClearListener clearlistener = new ButtonClearListener();
        btSend.setOnClickListener(listener);
        btconfirm.setOnClickListener(conlistener);
        btCear.setOnClickListener(clearlistener);
    }



    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            EditText name=findViewById(R.id.etName);
            EditText title=findViewById(R.id.etMailtitle);
            EditText adress=findViewById(R.id.etMail);
            EditText situmon=findViewById(R.id.etComment);
            String show = "名前:"+name.getText().toString()+"\n"+"メールタイトル:"+title.getText().toString()+"\n"+"メールアドレス:"+adress.getText().toString()+"\n"+"質問内容:"+situmon.getText().toString();
            Toast.makeText(getApplicationContext(),show, Toast.LENGTH_LONG).show();

        }
    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();



            dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");


//            HelloListener listener = new HelloListener();
//            listener.onClick(view);
        }
    }

    //ダイアログの送信ボタンを押したらSendボタンを押したことにする
    public void onDialogPositiveClick() {
        btSend.performClick();
    }



    private class ButtonClearListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            EditText inputcomment =findViewById(R.id.etComment);
            EditText inputname =findViewById(R.id.etName);
            EditText inputmailtitle =findViewById(R.id.etMailtitle);
            EditText inputmail =findViewById(R.id.etMail);
            inputname.setText("");
            inputcomment.setText("");
            inputmail.setText("");
            inputmailtitle.setText("");


        }
    }
}
