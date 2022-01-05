package com.example.recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃 매니저는 리싸이클러뷰가 보일 기본적인 형태를 설정할 때 사용한다.
        //LinearLayoutManager : 세로방향(Vertical), 가로방향(Horizontal)
        //GridLayoutManager : 격자모양

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("김민수", "010-1000-1000"));
        adapter.addItem(new Person("김하늘", "010-2000-2000"));
        adapter.addItem(new Person("홍길동", "010-3000-3000"));

        recyclerView.setAdapter(adapter);


        //어댑터 객체에 setOnItemClickListener 메소드를 호출하면서 리스너 객체를 설정하였다.
        //이렇게 하면 각 아이템이 클릭되었을 때 이 리스너의 onItemClick 메소드가 호출된다.
        //onItemClick 메소드 안에서는 어댑터 객체의 getItem 메소드를 이용해 클릭된 아이템 객체를 확인한다.
        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택됨: " + item.getName(),
                        Toast.LENGTH_SHORT).show();;
            }
        });

    }
}