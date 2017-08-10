package app.vini.com.meadota.Fragments.Cadastro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import app.vini.com.meadota.R;
import app.vini.com.meadota.Util.SignupFragment;


public class UserRegistrationContactFragment extends SignupFragment implements View.OnClickListener {

    Button createDoctor;
    TextInputLayout mStreet, mNumber, mCity, mState, mCep;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup officeGroup = (ViewGroup) inflater.inflate(R.layout.fragment_cadastro1, container, false);
        //createDoctor = (Button) officeGroup.findViewById(R.id.btCreateAccount);
        createDoctor.setOnClickListener(this);
        return officeGroup;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mStreet = (TextInputLayout) view.findViewById(R.id.tilStreet);
        //mState = (TextInputLayout) view.findViewById(R.id.tilState);
        //mCity = (TextInputLayout) view.findViewById(R.id.tilCity);
        //mNumber = (TextInputLayout) view.findViewById(R.id.tilNumber);
        //mCep = (TextInputLayout) view.findViewById(R.id.tilCep);
    }

    @Override
    public void onClick(View view) {
        String street = mStreet.getEditText().getText().toString();
        String number = mNumber.getEditText().getText().toString();
        String city = mCity.getEditText().getText().toString();
        String state = mState.getEditText().getText().toString();
        String cep = mCep.getEditText().getText().toString();
        //EventBus.getDefault().post(new DoctorOfficeDataEvent(street, number, cep, city, state));
    }
}
