package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button num0_btn;
    private Button num1_btn;
    private Button num2_btn;
    private Button num3_btn;
    private Button num4_btn;
    private Button num5_btn;
    private Button num6_btn;
    private Button num7_btn;
    private Button num8_btn;
    private Button num9_btn;
    private Button mult_btn;
    private Button divide_btn;
    private Button dot_btn;
    private Button result_btn;
    private Button back_btn;
    private Button delete_btn;
    private Button plus_btn;
    private Button minus_btn;
    private Button left_btn;
    private Button right_btn;
    private Button blank_btn;

    private TextView textview_1;
    //"("的标志,等于0在堆栈外,等于一在堆栈内
    private int flag = 0;
    //
    private List<String> expression_list;
    private List<String> after_expression_list;
    private String expression;
    private String after_expression;
    private Stack<String> stack1;
    private Stack<String> stack2;
    private List<String> str1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0_btn = (Button) findViewById(R.id.num0_btn);
        num1_btn = (Button) findViewById(R.id.num1_btn);
        num2_btn = (Button) findViewById(R.id.num2_btn);
        num3_btn = (Button) findViewById(R.id.num3_btn);
        num4_btn = (Button) findViewById(R.id.num4_btn);
        num5_btn = (Button) findViewById(R.id.num5_btn);
        num6_btn = (Button) findViewById(R.id.num6_btn);
        num7_btn = (Button) findViewById(R.id.num7_btn);
        num8_btn = (Button) findViewById(R.id.num8_btn);
        num9_btn = (Button) findViewById(R.id.num9_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        mult_btn = (Button) findViewById(R.id.mult_btn);
        dot_btn = (Button) findViewById(R.id.dot_btn);
        result_btn = (Button) findViewById(R.id.result_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        back_btn = (Button) findViewById(R.id.back_btn);
        plus_btn = (Button) findViewById(R.id.plus_btn);
        minus_btn = (Button) findViewById(R.id.minus_btn);
        left_btn = (Button) findViewById(R.id.left_btn);
        right_btn = (Button) findViewById(R.id.right_btn);

        textview_1 = (TextView) findViewById(R.id.textview_1);



        num0_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //
                textview_1.append(num0_btn.getText().toString());
            }
        });

        num1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num1_btn.getText().toString());
            }
        });

        num2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num2_btn.getText().toString());
            }
        });

        num3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num3_btn.getText().toString());
            }
        });

        num4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num4_btn.getText().toString());
            }
        });

        num5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num5_btn.getText().toString());
            }
        });

        num6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num6_btn.getText().toString());
            }
        });

        num7_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num7_btn.getText().toString());
            }
        });

        num8_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(num8_btn.getText().toString());
            }
        });

        num9_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println(textview_1.getText());
                textview_1.append(num9_btn.getText().toString());
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview_1.getText() == "0") {
                    textview_1.setText("");
                }
                textview_1.setText("");
            }
        });

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(plus_btn.getText().toString());
                // textview_1.setText("");
            }
        });

        mult_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(mult_btn.getText().toString());
                //textview_1.setText("");
            }
        });

        divide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(divide_btn.getText().toString());
                //textview_1.setText("");
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(minus_btn.getText().toString());
                //textview_1.setText("");
            }
        });

        left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(left_btn.getText().toString());
                //textview_1.setText("");
            }
        });

        right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview_1.append(right_btn.getText().toString());
                //textview_1.setText("");
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_1.setText(textview_1.getText().toString().substring(0, textview_1.getText().toString().length()-1));
            }
        });

        result_btn.setOnClickListener(new View.OnClickListener() //匿名接口实现类
        {
            @Override
            public void onClick(View view) {
                //初始化成员变量
                expression = textview_1.getText().toString();
                after_expression = "";
                expression_list = split(expression, "[/*+)(-]");
                str1 = Arrays.asList("+", "-", "*", "/","(",")", "^", "%");
                //设计栈进行操作
                stack1 = new Stack<>();
                stack2 = new Stack<>();
                //得到后缀表达式，用一个栈
                initStack1();
                //计算后缀表达式，再用一个栈
                initStack2();
                //返回结果
                textview_1.setText(stack2.pop());
            }

            private void initStack1() {
                for(int i = 0; i < expression_list.size() ; i++){
                    //运算数
                    if (!str1.contains(expression_list.get(i))){
                        if (expression_list.get(i).equals(".")){
                            //暂时不考虑小数
//                            String temp = stack1.pop();
//                            temp += expression_list[i+1];
//
//                            i += 1;

                        } else{
                            after_expression = after_expression + "(" + expression_list.get(i) + ")";
                        }

                    } else{
                        //操作符
                        //优先级高
                        if (stack1.isEmpty() || getPriority(expression_list.get(i)) > getPriority(stack1.lastElement())){
                            stack1.push(expression_list.get(i));
                            if (expression_list.get(i).equals("(")){
                                flag += 1;//如果是放入"(",放入的时候降低优先级
                            }
                        }
                        else if (expression_list.get(i).equals(")")){
                            while(!stack1.lastElement().equals("(")){
                                after_expression += stack1.pop();//不断弹出

                                if (stack1.lastElement().equals("(")){
                                    String temp = stack1.pop();//弹出“（”
                                    break;
                                }
                            }

                        }
                        else {
                            //优先级低
                            while(!stack1.isEmpty() || getPriority(stack1.lastElement()) >= getPriority(expression_list.get(i))){
                                //取出所有优先级低的
                                after_expression += stack1.pop();
                                //到“（“暂停
                                if (stack1.isEmpty() ||stack1.lastElement().equals("(")){
                                    break;
                                }

//                        if (stack1.lastElement().equals("(")){
//                            break;
//                        } else{
//                            after_expression += stack1.pop();
//                        }
                            }
                            stack1.push(expression_list.get(i));

                        }
                    }
                }
                while(!stack1.isEmpty() ){
                    //直到stack1为空
                    after_expression += stack1.pop();
                }
            }

            private void initStack2() {
                after_expression_list = split2(after_expression, "[/*+)(-]");
                for (String e : after_expression_list){
                    if (str1.contains(e)){
                        //操作符
                        double i1 = Double.parseDouble(stack2.pop());
                        double i2 = Double.parseDouble(stack2.pop());
                        double i3 = calculateNumbers(i2, i1, e);
                        stack2.push(String.valueOf(i3));//把新数据插入当中
                    } else {
                        //运算数
                        stack2.push(e);
                    }
                }
            }

            public double calculateNumbers(double num1, double num2, String operator) {
                switch(operator) {
                    case "+":
                        return num1 + num2;
                    case "-":
                        return num1 - num2;
                    case "*":
                        return num1 * num2;
                    case "/":
                        return num1 / num2;
                    case "%":
                        return num1 % num2;
//            case "^":
//                return num1 ^ num2;
                }
                return 0;
            }


            private int getPriority(String firstElement) {
                int priority = 0;
                switch (firstElement){
                    case "+":
                        return 1;
                    case "-":
                        return 1;
                    case "*":
                        return 2;
                    case "/":
                        return 2;
                    case "(":
                        priority = flag == 0 ? 5 : 0;
                        return priority;
                    default:
                        break;
                }
                return 0;
            }

            public ArrayList<String> split(String s, String regex){
                ArrayList<String> arr= new ArrayList<String> ();
                int i=0,j=0;//i记录的是s的从第一个字符到第一个分隔符的长度
                while(i < s.length())
                {
                    if (s.substring(i, i+1).matches(regex)){
                        //i字符匹配正则表达式
                        if(i != 0){
                            //有之前的内容
                            arr.add(s.substring(0, i));
                            j++;//arr第j个元素
                            arr.add(s.substring(i, i+1));
                            j++;
                            s = s.substring(i+1);
                            //从新的s的第一个元素开始遍历
                            i = 0;
                        } else{
                            arr.add(s.substring(i, i+1));
                            j++;
                            s = s.substring(i+1);
                            //从新的s的第一个元素开始遍历
                            i = 0;
                        }
                        //表达式之前内容装入，表达式装入，表达式之后装入
                    } else{
                        //不匹配
                        i++;
                    }
                }
                //最后一定只剩下不满足通配符的内容，但是可能为空
                arr.add(s);
                j++;
                ArrayList<String> trimed_arr = new ArrayList<>(arr.size()); //定义新的字符串数组，存放newStringArray修剪后的内容，保证输出无空值
                for (String value : arr) {
                    if (value != null && !value.equals(""))
                        trimed_arr.add(value);
                }
                return trimed_arr;
            }

            public ArrayList<String> split2(String s, String regex){
                ArrayList<String> arr= new ArrayList<String> ();
                int i=0,j=0;//i记录的是s的从第一个字符到第一个分隔符的长度
                while(i < s.length())
                {
                    if (s.substring(i, i+1).matches(regex)){
                        //i字符匹配正则表达式
                        if(i != 0){
                            //有之前的内容
                            arr.add(s.substring(0, i));
                            j++;//arr第j个元素
                            //把（）排除在外
                            if (s.charAt(i) != '(' && s.charAt(i) != ')'){
                                arr.add(s.substring(i, i+1));
                            }
                            j++;
                            s = s.substring(i+1);
                            //从新的s的第一个元素开始遍历
                            i = 0;
                        } else{
                            if (s.charAt(i) != '(' && s.charAt(i) != ')'){
                                arr.add(s.substring(i, i+1));
                            }
                            s = s.substring(i+1);
                            //从新的s的第一个元素开始遍历
                            i = 0;
                        }
                        //表达式之前内容装入，表达式装入，表达式之后装入
                    } else{
                        //不匹配
                        i++;
                    }
                }
                //最后一定只剩下不满足通配符的内容，但是可能为空
                arr.add(s);
                j++;

                ArrayList<String> trimed_arr = new ArrayList<>(arr.size()); //定义新的字符串数组，存放newStringArray修剪后的内容，保证输出无空值
                for (String value : arr) {
                    if (value != null && !value.equals(""))
                        trimed_arr.add(value);
                }
                return trimed_arr;
            }

















































//            public void initStack1(Stack<String> stack1){
//                expression_list = split(expression, "[/*+)(-]");
//                for (int i = 0; i < expression_list.size(); i++) {
//                    //运算数
//                    if (!str1.contains(expression_list.get(i))) {
//                        if (expression_list.get(i).equals(".")) {
//                            //暂时不考虑小数
////                            String temp = stack1.pop();
////                            temp += expression_list[i+1];
////                            i += 1;
//                        } else {
//                            after_expression += expression_list.get(i);
//                        }
//
//                    } else {
//                        //操作符
//                        //优先级高
//                        if (stack1.isEmpty() || getPriority(expression_list.get(i)) > getPriority(stack1.lastElement())) {
//                            stack1.push(expression_list.get(i));
//                            if (expression_list.get(i).equals("(")) {
//                                flag += 1;//如果是放入"(",放入的时候降低优先级
//                            }
//                        } else if (expression_list.get(i).equals(")")) {
//                            while (!stack1.lastElement().equals("(")) {
//                                after_expression += stack1.pop();//不断弹出
//
//                                if (stack1.lastElement().equals("(")) {
//                                    String temp = stack1.pop();//弹出“（”
//                                    break;
//                                }
//                            }
//
//                        } else {
//                            //优先级低
//                            while (!stack1.isEmpty() || getPriority(stack1.lastElement()) >= getPriority(expression_list.get(i))) {
//                                //取出所有优先级低的
//                                after_expression += stack1.pop();
//                                //到“（“暂停
//                                if (stack1.isEmpty() || stack1.lastElement().equals("(")) {
//                                    break;
//                                }
//
////                        if (stack1.lastElement().equals("(")){
////                            break;
////                        } else{
////                            after_expression += stack1.pop();
////                        }
//                            }
//                            stack1.push(expression_list.get(i));
//
//                        }
//                    }
//                }
//                while (!stack1.isEmpty()) {
//                    //直到stack1为空
//                    after_expression += stack1.pop();
//                }
//            }
//            private void initStack2(Stack<String> stack2) {
//                after_expression_list = new ArrayList<>();
//                after_expression_list.add("1");
//                after_expression_list.add("+");
//                after_expression_list.add("2");
//                after_expression_list.add("*");
//                after_expression_list.add("6");
//                for (String e : after_expression_list) {
//                    if (str1.contains(e)) {
//                        //操作符
//                        double i1 = Double.parseDouble(stack2.pop());
//                        double i2 = Double.parseDouble(stack2.pop());
//                        double i3 = calculateNumbers(i2, i1, e);
//                        stack2.push(String.valueOf(i3));//把新数据插入当中
//                    } else {
//                        //运算数
//                        stack2.push(e);
//                    }
//                }
//            }
//            private int getPriority(String firstElement) {
//                int priority = 0;
//                switch (firstElement) {
//                    case "+":
//                        return 1;
//                    case "-":
//                        return 1;
//                    case "*":
//                        return 2;
//                    case "/":
//                        return 2;
//                    case "(":
//                        priority = flag == 0 ? 5 : 0;
//                        return priority;
//                    default:
//                        break;
//                }
//                return 0;
//            }
//            public double calculateNumbers(double num1, double num2, String operator) {
//                switch (operator) {
//                    case "+":
//                        return num1 + num2;
//                    case "-":
//                        return num1 - num2;
//                    case "*":
//                        return num1 * num2;
//                    case "/":
//                        return num1 / num2;
//                    case "%":
//                        return num1 % num2;
////                    case "^":
////                        return num1 ^ num2;
//                }
//                return 0;
//            }
//            public ArrayList<String> split(String s, String regex){
//                ArrayList<String> arr= new ArrayList<String> ();
//                int i=0,j=0;//i记录的是s的从第一个字符到第一个分隔符的长度
//                while(i < s.length())
//                {
//                    if (s.substring(i, i+1).matches(regex)){
//                        //i字符匹配正则表达式
//                        if(i != 0){
//                            //有之前的内容
//                            arr.add(s.substring(0, i));
//                            j++;//arr第j个元素
//                            arr.add(s.substring(i, i+1));
//                            j++;
//                            s = s.substring(i+1);
//                            //从新的s的第一个元素开始遍历
//                            i = 0;
//                        } else{
//                            arr.add(s.substring(i, i+1));
//                            j++;
//                            s = s.substring(i+1);
//                            //从新的s的第一个元素开始遍历
//                            i = 0;
//                        }
//                        //表达式之前内容装入，表达式装入，表达式之后装入
//                    } else{
//                        //不匹配
//                        i++;
//                    }
//                }
//                //最后一定只剩下不满足通配符的内容，但是可能为空
//                arr.add(s);
//                j++;
//                ArrayList<String> trimed_arr = new ArrayList<>(arr.size()); //定义新的字符串数组，存放newStringArray修剪后的内容，保证输出无空值
//                for (String value : arr) {
//                    if (value != null && !value.equals(""))
//                        trimed_arr.add(value);
//                }
//                return trimed_arr;
//            }
//            public ArrayList<String> split2(String s, String regex){
//                ArrayList<String> arr= new ArrayList<String> ();
//                int i=0,j=0;//i记录的是s的从第一个字符到第一个分隔符的长度
//                while(i < s.length())
//                {
//                    if (s.substring(i, i+1).matches(regex)){
//                        //i字符匹配正则表达式
//                        if(i != 0){
//                            //有之前的内容
//                            arr.add(s.substring(0, i));
//                            j++;//arr第j个元素
//                            //把（）排除在外
//                            if (s.charAt(i) != '(' && s.charAt(i) != ')'){
//                                arr.add(s.substring(i, i+1));
//                            }
//                            j++;
//                            s = s.substring(i+1);
//                            //从新的s的第一个元素开始遍历
//                            i = 0;
//                        } else{
//                            if (s.charAt(i) != '(' && s.charAt(i) != ')'){
//                                arr.add(s.substring(i, i+1));
//                            }
//                            s = s.substring(i+1);
//                            //从新的s的第一个元素开始遍历
//                            i = 0;
//                        }
//                        //表达式之前内容装入，表达式装入，表达式之后装入
//                    } else{
//                        //不匹配
//                        i++;
//                    }
//                }
//                //最后一定只剩下不满足通配符的内容，但是可能为空
//                arr.add(s);
//                j++;
//
//                ArrayList<String> trimed_arr = new ArrayList<>(arr.size()); //定义新的字符串数组，存放newStringArray修剪后的内容，保证输出无空值
//                for (String value : arr) {
//                    if (value != null && !value.equals(""))
//                        trimed_arr.add(value);
//                }
//                return trimed_arr;
//            }
        });
    }
}






