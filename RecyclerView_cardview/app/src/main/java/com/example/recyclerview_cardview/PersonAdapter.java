package com.example.recyclerview_cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


//PersonAdapter 클래스 정의하기 (어댑터 + 뷰홀더)
//어댑터 : 데이터를 바탕으로 리사이클러뷰에 표시될 아이템 뷰를 생성한다
//뷰홀더 : 화면에 표시될 아이템 뷰를 저장하는 객체
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonItemClickListener{
    //어댑터 클래스가 새로 정의한 리스너 인터페이스 구현하도록 설정

    ArrayList<Person> items = new ArrayList<Person>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //뷰 홀더를 생성하고 붙여주는 부분
        //뷰홀더 객체가 만들어질 때 자동으로 호출

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //onCreateViewHolder( ) 메소드 안에서 인플레이션을 진행하기 위해서는 Context 객체가 필요한데
        //파라미터로 전달되는 뷰그룹 객체의 getContext( ) 메소드를 이용하면 Context 객체를 참조할 수 있다.

        View itemView = inflater.inflate(R.layout.person_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        //재활용 되는 뷰가 호출하여 실행되는 메소드, 뷰 홀더를 전달하고 어댑터는
        //position의 데이터를 결합시킨다.

        //onBindViewHolder( ) 메소드는 재활용할 수 있는 뷰홀더 객체를 파라미터로 전달하기 때문에
        //그 뷰홀더에 현재 아이템에 맞는 데이터만 설정하면 된다.
        Person item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        //데이터의 개수를 반환한다.
        //전체 아이템의 개수
        return items.size();
    }

    //어댑터가 각가의 아이템을 위한 Person 객체를 ArrayList 안에 넣어 관리하기 때문에
    //이 어댑터를 사용하는 소스 코드에서 어댑터에 Person 객체를 넣거나 가져갈 수 있도록
    //addItem( ), setItems( ), getItem( ), setItem( ) 메소드를 추가한다.
    public void addItem(Person item) {
        //외부에서 RecyclerView에 데이터를 추가할 때 사용합니다.
        //매개변수로 User 데이터 관리 클래스의 값을 (name, birth, phone) 등을 받아오는 역할을 합니다.
        //그 후 Adapter 클래스 안에 포함된 items 데이터 배열에 저장을 하여 추후 사용할 수 있도록 합니다.
        items.add(item);
    }

    public void setItems(ArrayList<Person> items) {
        this.items = items;
    }

    public Person getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Person item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {  //생성자 (전달되는 뷰 객체 참조)
            //final OnPersonItemClickListener listener 사용이유?
            //아이템뷰에 OnClickListener 설정하기
            //아이템 뷰 클릭 시 미리 정의한 다른 리스너의 메소드 호출

            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            //아이템뷰에 OnClickListener 설정하기
            //아이템 뷰 클릭 시 미리 정의한 다른 리스너의 메소드 호출
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Person item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }

    }
    public void setOnItemClickListener(OnPersonItemClickListener listener){
        //외부에서 리스너를 설정할 수 있도록 메소드 추가 ( setOnItemClickListener )
        this.listener = listener;
    }


    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        //onItemClick 메소드가 호출되었을 때 다시 외부에서 설정된 메소드가 호출
        if (listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

}