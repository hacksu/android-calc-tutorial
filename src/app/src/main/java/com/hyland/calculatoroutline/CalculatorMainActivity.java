package com.hyland.calculatoroutline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hyland.calculatorfull.R;

public class CalculatorMainActivity extends AppCompatActivity implements View.OnClickListener
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

        if(savedInstanceState != null)
        {

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

    }

    private void setupNumbers()
    {

    }

    private void setupAdd()
    {

    }

    private void setupSubtract()
    {

    }

    private void setupMultiply()
    {

    }

    private void setupDivide()
    {

    }

    private void setupClear()
    {
        
    }

    private void setupTotal()
    {

    }

    private String getDisplayValue()
    {
        TextView displayView = (TextView)findViewById(R.id.text_view_display);
        return displayView.getText().toString();
    }

    private void setDisplayValue(String value)
    {
        TextView displayView = (TextView)findViewById(R.id.text_view_display);
        displayView.setText(value);
    }

    private String performFunction(String leftOperand, String rightOperand, FunctionType functionType)
    {
        return "";
    }

    private void concatDisplayView(String number)
    {

    }

    @Override
    public void onClick(View view)
    {

    }
}
