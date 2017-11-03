package com.hyland.calculatorfull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
            _currentFunctionType = FunctionType.values()[savedInstanceState.getInt(FUNCTION_TYPE_KEY, FunctionType.NONE.ordinal())];
            _previousTotal = savedInstanceState.getString(PREVIOUS_TOTAL_KEY, "0");
            _createNewNumber = savedInstanceState.getBoolean(CREATE_NEW_NUMBER_KEY, true);

            TextView displayView = (TextView)findViewById(R.id.text_view_display);
            displayView.setText(savedInstanceState.getString(DISPLAY_TEXT_KEY, "0"));
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
        outState.putInt(FUNCTION_TYPE_KEY, _currentFunctionType.ordinal());
        outState.putString(PREVIOUS_TOTAL_KEY, _previousTotal);
        outState.putBoolean(CREATE_NEW_NUMBER_KEY, _createNewNumber);

        TextView displayView = (TextView)findViewById(R.id.text_view_display);
        outState.putString(DISPLAY_TEXT_KEY, displayView.getText().toString());
    }

    private void setupNumbers()
    {
        Button numberButton = (Button)findViewById(R.id.button_0);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_1);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_2);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_3);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_4);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_5);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_6);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_7);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_8);
        numberButton.setOnClickListener(this);

        numberButton = (Button)findViewById(R.id.button_9);
        numberButton.setOnClickListener(this);
    }

    private void setupAdd()
    {
        Button addButton = (Button)findViewById(R.id.button_add);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculate();
                _createNewNumber = true;
                _currentFunctionType = FunctionType.ADD;
            }
        });
    }

    private void setupSubtract()
    {
        Button subtractButton = (Button)findViewById(R.id.button_subtract);
        subtractButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculate();
                _createNewNumber = true;
                _currentFunctionType = FunctionType.SUBTRACT;
            }
        });
    }

    private void setupMultiply()
    {
        Button multiplyButton = (Button)findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculate();
                _createNewNumber = true;
                _currentFunctionType = FunctionType.MULTIPLY;
            }
        });
    }

    private void setupDivide()
    {
        Button divideButton = (Button) findViewById(R.id.button_divide);
        divideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculate();
                _createNewNumber = true;
                _currentFunctionType = FunctionType.DIVIDE;
            }
        });
    }

    private void setupClear()
    {
        Button clearButton = (Button) findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                _currentFunctionType = FunctionType.NONE;
                _previousTotal = "0";
                setDisplayValue(_previousTotal);
            }
        });
    }

    private void setupTotal()
    {
        Button totalButton = (Button)findViewById(R.id.button_total);
        totalButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculate();
            }
        });
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

    private void calculate()
    {
        String rightOperand = getDisplayValue();

        if(_currentFunctionType == FunctionType.NONE)
        {
            _previousTotal = rightOperand;
        }
        else
        {
            _previousTotal  = performFunction(_previousTotal, rightOperand, _currentFunctionType);
            _currentFunctionType = FunctionType.NONE;
            setDisplayValue(_previousTotal);
        }
    }

    private String performFunction(String leftOperand, String rightOperand, FunctionType functionType)
    {
        long leftNumber = Long.parseLong(leftOperand);
        long rightNumber = Long.parseLong(rightOperand);

        switch (functionType)
        {
            case ADD:
                return String.valueOf(Functions.add(leftNumber, rightNumber));
            case SUBTRACT:
                return String.valueOf(Functions.subtract(leftNumber, rightNumber));
            case MULTIPLY:
                return String.valueOf(Functions.multiply(leftNumber, rightNumber));
            case DIVIDE:
                try
                {
                    return String.valueOf(Functions.divide(leftNumber, rightNumber));
                }
                catch (ArithmeticException e)
                {
                    Toast.makeText(CalculatorMainActivity.this, "Cannot divide by zero. Use another number", Toast.LENGTH_LONG).show();
                }
                break;
        }

        return "";
    }

    private void concatDisplayView(String number)
    {
        if(_createNewNumber)
        {
            _createNewNumber = false;
            setDisplayValue(number);
        }
        else
        {
            String currentText = getDisplayValue();
            currentText += number;
            setDisplayValue(currentText);
        }

    }

    @Override
    public void onClick(View view)
    {
        String clickedNumber = ((Button)view).getText().toString();

        if(_currentFunctionType == FunctionType.NONE)
        {
            //if start of the equation, update view and previous total
            if (getDisplayValue().equals("0"))
            {
                setDisplayValue(clickedNumber);
            }
            else
            {
                concatDisplayView(clickedNumber);
            }
        }
        else
        {
            concatDisplayView(clickedNumber);
        }
    }
}
