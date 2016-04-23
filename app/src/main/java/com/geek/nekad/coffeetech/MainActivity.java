package com.geek.nekad.coffeetech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        if (quantity == 100){
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if (quantity == 1){
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /*
    * Ini method untuk menampilkan isi quantity text di layar
    */
    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.txt_quantity);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int price){
        TextView quantityTextView = (TextView) findViewById(R.id.txt_price);
        quantityTextView.setText("" + price);
    }

    private void displayMassage (String priceMassage){
        TextView quantityTextView = (TextView) findViewById(R.id.txt_price);
        quantityTextView.setText("" + priceMassage);
    }

    private int calculatorPrice(){
        return quantity * 5;
    }

    public void submitOrder(View view) {
       // calculatorPrice(quantity);

        EditText yourName = (EditText) findViewById(R.id.editText_yourname);
        String valueName = yourName.getText().toString();

        //checkBox
        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.checkBox_whipped);
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.checkBox_choco);
        boolean hasWhippedCream = WhippedCreamCheckBox.isChecked();
        boolean hasChocolate = ChocolateCheckBox.isChecked();

        int price = calculatorPrice();
        String priceMassage = createOrderSummary(price, hasWhippedCream, hasChocolate, valueName);
        displayMassage(priceMassage);
    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String valueName){
        String priceMassage = "Name : " + valueName;
        priceMassage = priceMassage + "\nAdd Whipped Cream: " + hasWhippedCream;
        priceMassage = priceMassage + "\nAdd Chocolate: " + hasChocolate;
        priceMassage = priceMassage + "\nQuantity: $" + quantity;
        priceMassage = priceMassage + "\nTotal: $" + price;
        priceMassage = priceMassage + "\nThank You";
        return priceMassage;
    }


}

