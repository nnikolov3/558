package nikos.terminal.calculator.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import nikos.terminal.calculator.R;

import static nikos.terminal.calculator.R.string.emptyStr;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Button addButton;
    private Button subtractButton;
    private Button divideButton;
    private Button multiplyButton;
    private Button squareRootButton;
    private Button percentButton;

    private TextView displayResult;

    private EditText userInputTop;
    private EditText userInputBottom;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        addButton = getView().findViewById(R.id.add);
        subtractButton = getView().findViewById(R.id.subtract);
        divideButton = getView().findViewById(R.id.divide);
        multiplyButton = getView().findViewById(R.id.multiply);
        percentButton = getView().findViewById(R.id.percent);
        squareRootButton = getView().findViewById(R.id.square_root);

        userInputBottom = getView().findViewById(R.id.userInputBottom);
        userInputTop = getView().findViewById(R.id.userInputTop);

        displayResult = getView().findViewById(R.id.result);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidInput(userInputTop.getText().toString(),userInputBottom.getText().toString())){
                    Snackbar.make(v, "Cannot be empty!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }

                mViewModel.setUserInputTop(userInputTop.getText().toString());
                mViewModel.setUserInputBottom(userInputBottom.getText().toString());
                displayResult.setText(String.format(Locale.getDefault(), "%.2f", mViewModel.addition()));
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidInput(userInputTop.getText().toString(),userInputBottom.getText().toString())){
                    Snackbar.make(v, "Cannot be empty!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }

                mViewModel.setUserInputTop(userInputTop.getText().toString());
                mViewModel.setUserInputBottom(userInputBottom.getText().toString());
                displayResult.setText(String.format(Locale.getDefault(), "%.2f", mViewModel.subtraction()));
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidInput(userInputTop.getText().toString(),userInputBottom.getText().toString())){
                    Snackbar.make(v, "Cannot be empty!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }

                if (Double.parseDouble(userInputBottom.getText().toString()) == 0) {
                    Snackbar.make(v, "Error: Divide by 0!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }


                mViewModel.setUserInputTop(userInputTop.getText().toString());
                mViewModel.setUserInputBottom(userInputBottom.getText().toString());
                displayResult.setText(String.format(Locale.getDefault(), "%.2f", mViewModel.division()));
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isValidInput(userInputTop.getText().toString(),userInputBottom.getText().toString())){
                    Snackbar.make(v, "Cannot be empty!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }

                mViewModel.setUserInputTop(userInputTop.getText().toString());
                mViewModel.setUserInputBottom(userInputBottom.getText().toString());
                displayResult.setText(String.format(Locale.getDefault(), "%.2f", mViewModel.multiply()));
            }
        });

        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isValidInput(userInputTop.getText().toString(),userInputBottom.getText().toString())){
                    Snackbar.make(v, "Cannot be empty!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }

                if (Double.parseDouble(userInputBottom.getText().toString()) == 0) {
                    Snackbar.make(v, "Error: Divide by 0!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }
                mViewModel.setUserInputTop(userInputTop.getText().toString());
                mViewModel.setUserInputBottom(userInputBottom.getText().toString());
                displayResult.setText(String.format(Locale.getDefault(), "%.2f", mViewModel.percent()));
            }
        });

        squareRootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isValidInput(userInputTop.getText().toString(),userInputBottom.getText().toString())){
                    Snackbar.make(v, "Cannot be empty!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }

                if (Double.parseDouble(userInputTop.getText().toString()) == 0) {
                    Snackbar.make(v, "Error: Cannot be 0 ", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }
                else if(Double.parseDouble(userInputTop.getText().toString()) < 0) {
                    Snackbar.make(v, "Error: Cannot be negative", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setBackgroundTint(Color.RED)
                            .setAnchorView(v)
                            .setTextColor(Color.WHITE).show();
                    clear_input();
                }


                mViewModel.setUserInputTop(userInputTop.getText().toString());
                mViewModel.setUserInputBottom(userInputBottom.getText().toString());
                displayResult.setText(String.format(Locale.getDefault(), "%.2f", mViewModel.squareRoot()));
            }
        });
    }

    private boolean isValidInput(String inputTop, String inputBottom) {
        String topInputString = inputTop;
        String bottomInputString = inputBottom;

        if (topInputString.isEmpty() || topInputString.equals("") || topInputString.length() == 0){
            return false;
        }

        if (bottomInputString.isEmpty() || bottomInputString.equals("") || bottomInputString.length() == 0){
            return false;
        }

        return true;
    }
        /**
         * Clears the input text edit boxes
         */
        private void clear_input () {
            userInputTop.setText(emptyStr);
            userInputBottom.setText(emptyStr);
        }
    }