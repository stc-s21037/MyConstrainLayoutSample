package jp.suntech.s21037.myconstrainlayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import static android.app.PendingIntent.getActivity;



public class OrderConfirmDialogFragment extends DialogFragment{




    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());




        builder.setTitle(R.string.dialog_title);

        builder.setMessage(R.string.dialog_msg);

        builder.setPositiveButton(R.string.dialog_btn_ok,new DialogButtonClickListener());

        builder.setNegativeButton(R.string.dialog_btn_ng,new DialogButtonClickListener());

        builder.setNeutralButton(R.string.dialog_btn_nu,new DialogButtonClickListener());

        AlertDialog dialog = builder.create();

        return dialog;

    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity callingActivity = (MainActivity) getActivity();

            String msg="";

            switch(which){
                case DialogInterface.BUTTON_POSITIVE:
                    callingActivity.onDialogPositiveClick();
                    break;
            }

        }


    }
}
