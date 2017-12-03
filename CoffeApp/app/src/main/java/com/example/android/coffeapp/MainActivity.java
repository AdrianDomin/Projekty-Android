/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 *
 */


package com.example.android.coffeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     */
    int allPrice = 0;
    int quantity = 0;
    int priceForCup = 5;
    String Name = "";
    String finalyMessage = "";
    public void submitOrder(View view) {

        CheckBox whippedCream = (CheckBox)findViewById (R.id.whipped_cream);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolate.isChecked();

        EditText nameText = (EditText) findViewById(R.id.textName);
        Name = nameText.getText().toString();

        calculatePrice(quantity, priceForCup, hasWhippedCream, hasChocolate);
        finalyMessage = createOrderSummar(hasWhippedCream, hasChocolate, Name);
        displayMessage(finalyMessage);
    }
    /** sent to mail - button - function */

    public void sendMail (View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order from: " + Name);
        intent.putExtra(Intent.EXTRA_TEXT, finalyMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }



    /** minus and plus button - function */

    public void increment (View view){
        if (quantity == 100){
            Toast.makeText(this, "You cannot order more than 100 coffees.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity +1;
        displayQuantity(quantity);
    }
    public void decrement (View view) {
        if (quantity == 1){
            Toast.makeText(this, "You cannot order less than 1 coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        displayQuantity(quantity);
    }

    /**This method displays value of coffees between plus and minus button.*/
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**This method displays message .*/
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }


    /**
     * This method displays price of coffes.
     * if coffee has whiped cream +1$ to price
     * if coffee has chocolate +2 $ to price
     */
    private int calculatePrice (int quantity, int priceForCup, boolean hasWhippedCream, boolean hasChocolate) {
        allPrice = quantity*priceForCup;
        if (hasChocolate) {
            allPrice +=  quantity * 2;
        }
        if (hasWhippedCream){
            allPrice +=  quantity*1;
        }
       return allPrice;
    }


    /** This metod creat order summary */
    private String createOrderSummar (boolean hasWippedCream, boolean hasChocolate, String Name) {
        String OrderSummary = "Name : "+ Name;
        OrderSummary +="\nQuantity: " + quantity;
        OrderSummary +="\nAddWhippedCream ?: " + hasWippedCream;
        OrderSummary +="\nAddChocolate ?: " + hasChocolate;
        OrderSummary +="\nTotal : $" + allPrice;
        OrderSummary +="\n "+ getString(R.string.thank_you);        /** tlumaczenie na inne jezyki - link to stringa w strings.xml */
        return OrderSummary;
    }

}
