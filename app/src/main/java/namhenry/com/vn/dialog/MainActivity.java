package namhenry.com.vn.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showtime(View view) {
        //b1:lay thong tin che do 24
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        boolean is24HOURview=true;
        //b2:khoi dong
        TimePickerDialog dialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

            }
        },hour,minute,is24HOURview);
        //b3:hien thi
        dialog.show();
    }

    public void showarlert(View view) {
        //b1:dinh nghia alert
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //b2:thiet lap cac thong tin:title,message,icon,button
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("thong bao");
        // builder.setMessage("den ngayf mai phai cap nhat");
        //neu truong hop muon hien thi1 danh sach lua chon
        String[] ds={"nam","ha","hai","phong"};
        builder.setItems(ds, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //xu ly

            }
        });
        //b3:hien thi

        builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void showspiner(View view) {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("TAI DU LIEU");
        dialog.setMessage("dang tai....");
        dialog.setCancelable(true);//khi an nut back co thoat hay ko
      //  dialog.setCanceledOnTouchOutside(false);// khi cham ben ngoai co ket thc hay ko
        dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.show();
        //khi nao muon huy
       // dialog.dismiss();
    }

    public void showarhorizontor(View view) {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("TAI DU LIEU");
        dialog.setMessage("dang tai....");
        //   dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        //thiet lapkieu
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
        //khi nao muon huy
        // dialog.dismiss();
        //thay doi muc do hoan thanh cong viec
        dialog.setProgress(50);
    }

    public void showdate(View view) {
        //b1:lauy thang nam muon hien thi
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        //B2: khoi tao
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, day+"/"+(month+1)+"/"+year, Toast.LENGTH_SHORT).show();
            }
        },year,month,day);
        //hien thi
        dialog.show();

    }

    public void showcustom(View view) {
        Dialog dialog=new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.show();
        TextView textView=dialog.findViewById(R.id.tvmess);
        textView.setText("co muon nang cap ko");
        dialog.show();
    }
}
