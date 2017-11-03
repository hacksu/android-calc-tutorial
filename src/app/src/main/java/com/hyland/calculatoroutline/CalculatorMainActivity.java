package com.hyland.calculatoroutline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hyland.calculatorfull.R;

public class CalculatorMainActivity extends AppCompatActivity
{
    private FunctionType _currentFunctionType = FunctionType.NONE;
    private String _previousTotal = "0";
    private boolean _createNewNumber;

    private final String FUNCTION_TYPE_KEY = "functionTypeKey";
    private final String PREVIOUS_TOTAL_KEY = "previousTotalKey";
    private final String CREATE_NEW_NUMBER_KEY = "createNewNumberKey";
    private final String DISPLAY_TEXT_KEY = "displayTextKey";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        if (savedInstanceState != null)
        {
            // TODO 15: Restore variables from rotation.
        }

        setupNumbers();
        setupAdd();
        setupSubtract();
        setupMultiply();
        setupDivide();
        setupClear();
        setupTotal();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        // TODO 14: Save variables for rotation.
    }

    private void setupNumbers()
    {
        // TODO 1: Number Handlers
    }

    private void setupAdd()
    {
        // TODO 5: Add button handler
    }

    private void setupSubtract()
    {
        // You can implement this on your own.
    }

    private void setupMultiply()
    {
        // You can implement this on your own.
    }

    private void setupDivide()
    {
        // You can implement this on your own.
    }

    private void setupClear()
    {
        // TODO 13: Reset the calculator with the clear button.
    }

    private void setupTotal()
    {
        // TODO 12: Set up equals button to do the calculation.
    }

    // TODO 6: Create calculate stub.
    {
        // TODO 9: Get left and right operands.
        // TODO 11: Display the result.
    }


    private String getDisplayValue()
    {
        TextView displayView = (TextView) findViewById(R.id.text_view_display);
        return displayView.getText().toString();
    }

    private void setDisplayValue(String value)
    {
        TextView displayView = (TextView) findViewById(R.id.text_view_display);
        displayView.setText(value);
    }

    private String performFunction(String leftOperand, String rightOperand, FunctionType functionType)
    {
        // TODO 10: Do the calculation based on operator.
        return "";
    }

    private void concatDisplayView(String number)
    {
        // TODO 7: 'Append to' or 'Overwrite' the existing number
    }

    private class NumberClickListener implements View.OnClickListener
    {
        private int _buttonValue;

        public NumberClickListener(int buttonValue)
        {
            // TODO 2: Save button value
        }

        @Override
        public void onClick(View view)
        {
            // TODO 3: Show number when clicked.

            // TODO 4: Show multi-digit numbers.

            // TODO 8: Create a new number after pressing operator.
        }
    }
}
