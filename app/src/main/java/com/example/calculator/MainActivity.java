package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private TextView textview_1;
    //"("的标志,等于0在堆栈外,等于一在堆栈内
    private int flag = 0;

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

        result_btn.setOnClickListener(new View.OnClickListener() //匿名接口实现类
        {
            String after_expression = "";
            String[] expression_list;
            List<String> str1;
            String expression;
            @Override
            public void onClick(View view) {
                //输入的表达式
                expression = textview_1.getText().toString();
                //操作符优先级
                str1 = Arrays.asList("+", "-", "*", "/", "(", ")", "^", "%");
                //设计栈进行操作
                Stack<String> stack1 = new Stack<>();
                Stack<String> stack2 = new Stack<>();
                //得到后缀表达式，用一个栈
                initStack1(stack1);
                //计算后缀表达式，再用一个栈
                initStack2(stack2);
                //在textview返回结果
                textview_1.setText(stack2.pop());
            }
            public void initStack1(Stack<String> stack1){
                expression_list = expression.split("");
                for (int i = 0; i < expression_list.length; i++) {
                    //运算数
                    if (!str1.contains(expression_list[i])) {
                        if (expression_list[i].equals(".")) {
                            //暂时不考虑小数
//                            String temp = stack1.pop();
//                            temp += expression_list[i+1];
//                            i += 1;
                        } else {
                            after_expression += expression_list[i];
                        }

                    } else {
                        //操作符
                        //优先级高
                        if (stack1.isEmpty() || getPriority(expression_list[i]) > getPriority(stack1.lastElement())) {
                            stack1.push(expression_list[i]);
                            if (expression_list[i].equals("(")) {
                                flag += 1;//如果是放入"(",放入的时候降低优先级
                            }
                        } else if (expression_list[i].equals(")")) {
                            while (!stack1.lastElement().equals("(")) {
                                after_expression += stack1.pop();//不断弹出

                                if (stack1.lastElement().equals("(")) {
                                    String temp = stack1.pop();//弹出“（”
                                    break;
                                }
                            }

                        } else {
                            //优先级低
                            while (!stack1.isEmpty() || getPriority(stack1.lastElement()) >= getPriority(expression_list[i])) {
                                //取出所有优先级低的
                                after_expression += stack1.pop();
                                //到“（“暂停
                                if (stack1.isEmpty() || stack1.lastElement().equals("(")) {
                                    break;
                                }

//                        if (stack1.lastElement().equals("(")){
//                            break;
//                        } else{
//                            after_expression += stack1.pop();
//                        }
                            }
                            stack1.push(expression_list[i]);

                        }
                    }
                }
                while (!stack1.isEmpty()) {
                    //直到stack1为空
                    after_expression += stack1.pop();
                }
            }
            private void initStack2(Stack<String> stack2) {
                String[] after_expression_list = after_expression.split("");
                for (String e : after_expression_list) {
                    if (str1.contains(e)) {
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
            private int getPriority(String firstElement) {
                int priority = 0;
                switch (firstElement) {
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
            public Double calculateNumbers(double num1, double num2, String operator) {
                switch (operator) {
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
//                    case "^":
//                        return num1 ^ num2;
                }
                return null;
            }
        });
    }
}






