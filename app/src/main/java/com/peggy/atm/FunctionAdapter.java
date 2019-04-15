package com.peggy.atm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.FunctionViewHolder>{

    private final String[] functions;
    Context context;
    public FunctionAdapter(Context context) {
        this.context=context;
        functions= context.getResources().getStringArray(R.array.functions);  //取得含有各功能的字串陣列
    }

    @NonNull
    @Override
    public FunctionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {  //取得資料如何顯示
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,viewGroup,false);

        return new FunctionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionViewHolder functionViewHolder, int i) {  //資料傳入，將資料顯示
        functionViewHolder.nameText.setText(functions[i]);

    }

    @Override
    public int getItemCount() {   //取得數量
        return functions.length;
    }

    public class FunctionViewHolder extends RecyclerView.ViewHolder{

        TextView nameText;
        public FunctionViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText=itemView.findViewById(android.R.id.text1);
        }
    }
}
