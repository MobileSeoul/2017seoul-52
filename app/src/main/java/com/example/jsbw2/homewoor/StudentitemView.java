package com.example.jsbw2.homewoor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * LinearLayout을 상속한 새로운 클래스를 만들고
 * 이클래스안에섯 LayoutInflater객체를 이용해
 * xml 레이아웃의 ㅐㄴ용을 메모리에 객체화합니다,
 * 한 아이템으로 보여줄 뷰를 StudentItemView라는 이름으로 새로 정의
 */

public class StudentitemView extends LinearLayout {
    TextView textview;
    TextView textview2;
    TextView textview3;
    ImageView imageview;

    public StudentitemView(Context context) {
        super(context);
        init(context);
    }

    public StudentitemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.student_item,this,true);
        textview=(TextView) findViewById(R.id.textView);
        textview2=(TextView) findViewById(R.id.textView2);
        textview3=(TextView) findViewById(R.id.textView3);


    }
    public void setName(String name)   {
        textview.setText(name);
    }
    public void setTel(String tel) {
        textview2.setText(tel);
    }
    public void setClassNum(String classNum) {
        textview3.setText(classNum);
    }
    public void setStuPic(int stuPic){
        imageview.setImageResource(stuPic);
    }
}
