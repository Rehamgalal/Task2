package com.example.reham.task2;

import android.content.res.Configuration;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reham.task2.Retrofit.Calls;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.editTextName)
    EditText name;
    @BindView(R.id.editTextPassword)
    EditText password;
    @BindView(R.id.codeSpinner)
    Spinner code;
    @BindView(R.id.editTextCode)
    EditText eCode;
    @BindView(R.id.editTextMail)
    EditText mail;
    @BindView(R.id.countrySpinner)
    Spinner country;
    @BindView(R.id.citySpinner)
    Spinner city;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.terms)
    TextView terms;
    @BindView(R.id.fragment_container)
    LinearLayout frameLayout;
    @BindView(R.id.constraint)
    ConstraintLayout constraintLayout;
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    Calls call = new Calls();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        frameLayout.setVisibility(View.GONE);
        constraintLayout.setVisibility(View.VISIBLE);
        code.setOnItemSelectedListener(this);
        country.setOnItemSelectedListener(this);
        city.setOnItemSelectedListener(this);
        call.countryCall(this, code, country, "en");
        button.setOnClickListener(this);
        terms.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (country.getSelectedItemPosition() == country.getSelectedItemPosition()) {
            String CurrentLang = Locale.getDefault().getLanguage();
            if (parent.getId() == country.getId()) {
                if (CurrentLang.equals("en")) {
                    call.cityCall(this, city, country.getSelectedItemPosition() + 1, "en");
                } else if (CurrentLang.equals("ar")) {
                    call.cityCall(this, city, country.getSelectedItemPosition() + 1, "ar");
                }


                Toast.makeText(this, R.string.toast, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == button.getId()) {
            String CurrentLang = Locale.getDefault().getLanguage();
            Log.i("currentlang", "" + CurrentLang);
            if (CurrentLang.equals("en")) {
                String languageToLoad = "ar"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main);
                ButterKnife.bind(this);
                frameLayout.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);
                code.setOnItemSelectedListener(this);
                country.setOnItemSelectedListener(this);
                city.setOnItemSelectedListener(this);
                terms.setOnClickListener(this);
                button.setOnClickListener(this);
                call.countryCall(getBaseContext(), code, country, "ar");
            } else if (CurrentLang.equals("ar")) {
                String languageToLoad = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                this.setContentView(R.layout.activity_main);
                ButterKnife.bind(this);
                frameLayout.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);
                code.setOnItemSelectedListener(this);
                country.setOnItemSelectedListener(this);
                city.setOnItemSelectedListener(this);
                button.setOnClickListener(this);
                terms.setOnClickListener(this);
                call.countryCall(getBaseContext(), code, country, "en");
            }
        } else if (v.getId() == terms.getId()) {
            constraintLayout.setVisibility(View.GONE);
            frameLayout.setVisibility(View.VISIBLE);
            final WebFragment blankFragment = new WebFragment();
            final android.app.FragmentManager manager = getFragmentManager();
            manager.beginTransaction().add(R.id.fragment_container, blankFragment).commit();
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    manager.beginTransaction().remove(blankFragment).commit();
                    frameLayout.setVisibility(View.GONE);
                    constraintLayout.setVisibility(View.VISIBLE);
                }
            });
        }
    }

}

