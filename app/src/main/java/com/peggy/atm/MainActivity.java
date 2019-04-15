package com.peggy.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_LOGIN = 100;
    boolean login = false;
    String[] functions = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!login){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent,REQUEST_LOGIN);
            //startActivity(intent);
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //recycler
        RecyclerView recyclerView = findViewById(R.id.recycler); //去得layout中的recyclerview物件
        recyclerView.setHasFixedSize(true); //物件初始化，有固定大小
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //如何展示裡面每列內容

        //Adapter
        /*
        * Adapter設計中
        * 1.需要一個Adapter類別繼承RecyclerView.Adapter
        * 2.類別中需要設一單筆資料的ViewHolder類別
        * 3.設計一個單筆資料的Layout檔
        *
        * 實作中
        * 1.設計單筆資料類別
        * 2.建立Adapter類別  (FunctionAdapter.java)
        * 3.設計內部類別
        *   單筆資料viewHolder，繼承RecyclerView.ViewHolder
        * 4.Adapter繼承RecyclerView.Adapter
        *   實作方法(int getItemCount取得array功能筆數、ViewHolder onCreateViewHolder產生ViewHolder、void onBindViewHolder設定資料
        * new FunctionAdapter物件並setAdapter
        * */
        FunctionAdapter adapter = new FunctionAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_LOGIN){
            if(resultCode!=RESULT_OK){  //loginActivity正確登入時才reqCode才會=result ok，不等於時就代表登入有問題，直接關閉
                Log.d("MainActivity",""+requestCode+resultCode);
                finish();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
