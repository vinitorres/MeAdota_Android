package app.vini.com.meadota.Fragments.Cadastro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import app.vini.com.meadota.R;
import app.vini.com.meadota.Util.SignupFragment;


public class UserRegistrationLocationFragment extends SignupFragment implements View.OnClickListener{

    private Button nextStep;
    private Spinner mSpeciality;
    private TextInputLayout mName;
    private TextInputLayout mEmail;
    private TextInputLayout mCpf;
    private TextInputLayout mCrm;
    private TextInputLayout mPassord;
    private TextInputLayout mConfirmPassord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup inflateGroup = (ViewGroup) inflater.inflate(R.layout.fragment_cadastro1,container,false);

//        nextStep = (Button) inflateGroup.findViewById(R.id.btNextStep);
//        nextStep.setOnClickListener(this);
//
//        mSpeciality = (Spinner) inflateGroup.findViewById(R.id.spSpeciality);
//        List<Specialty> specialties = new ArrayList();
//        specialties.add(new Specialty("0",getString(R.string.choose_speciality)));
//        specialties.add(new Specialty("1","Ginecologista"));
//        specialties.add(new Specialty("2","Clinico geral"));

//        ArrayAdapter listAdapter = new ArrayAdapter(container.getContext(),R.layout.support_simple_spinner_dropdown_item, specialties);
//        mSpeciality.setAdapter(listAdapter);

        return inflateGroup;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        nextStep = (Button) view.findViewById(R.id.btNextStep);
//        mName = (TextInputLayout) view.findViewById(R.id.tilName);
//        mEmail = (TextInputLayout) view.findViewById(R.id.tilEmail);
//        mCpf = (TextInputLayout) view.findViewById(R.id.tilCpf);
//        mCrm = (TextInputLayout) view.findViewById(R.id.tilCrm);
//        mPassord = (TextInputLayout) view.findViewById(R.id.tilPassword);
//        mConfirmPassord = (TextInputLayout) view.findViewById(R.id.tilConfirmPassword);
    }


    @Override
    public void onClick(View view) {
        String name = mName.getEditText().getText().toString();
        String email = mEmail.getEditText().getText().toString();
        String cpf = mCpf.getEditText().getText().toString();
        String crm = mCrm.getEditText().getText().toString();
        String password = mPassord.getEditText().getText().toString();
        String confirmPassword = mConfirmPassord.getEditText().getText().toString();
        String speciality = mSpeciality.getSelectedItem().toString();
        //EventBus.getDefault().post(new DoctorPersonalDataEvent(name,email,password,confirmPassword,crm,cpf,speciality));
        if(getViewPager() != null) {
            getViewPager().setCurrentItem(1);
        }
    }
}
