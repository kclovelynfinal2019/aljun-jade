package com.example.iscofbnc.coffeapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numCoffee = 0;
    int coffeePrice = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView Total_view = (TextView) findViewById(R.id.gratuity_view);

        if(Total_view.getText().length() > 0){
            double Total = Double.parseDouble(Total_view.getText().toString());
            displayPrice(numCoffee * coffeePrice + Total);
        }

        else {
            displayPrice(numCoffee * coffeePrice);
        }
    }

    public void increment(View view){
        numCoffee++;
        display(numCoffee);
    }

    public void decrement(View view){
        if(numCoffee>0){
            numCoffee--;
        }
        display(numCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(double number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
