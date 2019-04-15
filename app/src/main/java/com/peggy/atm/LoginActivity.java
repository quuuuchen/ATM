package com.peggy.atm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText edUserid;
    private EditText edUserpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = findViewById(R.id.uid);
        edUserpd = findViewById(R.id.upd);

    }

    public void login(View view){
        String userid = edUserid.getText().toString();
        String userpd = edUserpd.getText().toString();
//        FirebaseDatabase.getInstance().getReference("users").child(userid).child("password")
//                //getInstance取得資料庫物件，reference輸入第一層名稱，child(app輸入jack)取得jack的password
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {    //資料回傳時執行onDataChange
//                        String pw = (String) dataSnapshot.getValue();   //取得資料庫中user的password為pw
//                        if(pw.equals(userpd)){
//                            setResult(RESULT_OK);
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
        //原本的方法，假的帳號密碼
        if("jack".equals(userid)&&"1234".equals(userpd)){
            setResult(RESULT_OK);   //只有登入成功時會回傳result_ok，供主畫面判斷是否正確登入
            finish();   //activity被呼叫時，會回到上一個activity
        }
    }

    public void quit(View view){

    }
}
