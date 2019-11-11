package com.example.hangout.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hangout.Models.Item;

import java.util.List;

public class ItemAdapter {



  public  class  ItemViewHolder extends RecyclerView.ViewHolder{

private List<Item> itemList;







      public ItemViewHolder(@NonNull View itemView) {
          super(itemView);
      }
  }


}
