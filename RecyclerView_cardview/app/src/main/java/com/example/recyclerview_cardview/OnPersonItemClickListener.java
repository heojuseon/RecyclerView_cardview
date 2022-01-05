package com.example.recyclerview_cardview;

import android.view.View;

public interface OnPersonItemClickListener {
    //OnPersonItemClickListener 인터페이스 작성
    //아이템 뷰가 클릭되면 자동으로 호출될 메소드 작성
    //뷰홀더 객체, 뷰 객체, 뷰의 position 정보가 전달되도록 설정 ( position : 몇 번째 아이템인지를 구분할 수 있는 인덱스 )


    public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position);
}
